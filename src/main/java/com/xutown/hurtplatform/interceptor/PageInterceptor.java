package com.xutown.hurtplatform.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.RowBounds;

import com.xutown.hurtplatform.query.PageParameter;


/**
 * mysql分页
 * 
 */
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PageInterceptor implements Interceptor {
	private static final Log logger = LogFactory.getLog(PageInterceptor.class);

	private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();

	private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();

	private static final ReflectorFactory DEFAULT_REFLECTOR_FACTORY = new DefaultReflectorFactory();

	private static String defaultDialect = "mysql"; // 数据库类型

	private static String defaultPageSqlId = ".*Page*$"; // 需要拦截的ID
	
	private static String dialect = ""; // 数据库类型(默认为mysql)

	/**
	 * @param dialect the dialect to set
	 */
	public static void setDialect(String dialect) {
		PageInterceptor.dialect = dialect;
	}

	/**
	 * @param pageSqlId the pageSqlId to set
	 */
	public static void setPageSqlId(String pageSqlId) {
		PageInterceptor.pageSqlId = pageSqlId;
	}


	private static String pageSqlId = ""; // 需要拦截的ID(正则匹配)

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation
				.getTarget();
		MetaObject metaStatementHandler = MetaObject.forObject(
				statementHandler, DEFAULT_OBJECT_FACTORY,
				DEFAULT_OBJECT_WRAPPER_FACTORY, DEFAULT_REFLECTOR_FACTORY);
		while (metaStatementHandler.hasGetter("h")) {//分离代理对象链
			Object object = metaStatementHandler.getValue("h");
			metaStatementHandler = MetaObject.forObject(object,
					DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY,
					DEFAULT_REFLECTOR_FACTORY);
		}
		
		while (metaStatementHandler.hasGetter("target")) {//分离最后一个代理对象的目标类
			Object object = metaStatementHandler.getValue("target");
			metaStatementHandler = MetaObject.forObject(object,
					DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY,
					DEFAULT_REFLECTOR_FACTORY);
		}
		if (null == dialect || "".equals(dialect)) {
			logger.warn("Property dialect is not setted,use default 'mysql' ");
			dialect = defaultDialect;
		}
		if (null == pageSqlId || "".equals(pageSqlId)) {
			logger.warn("Property pageSqlId is not setted,use default '.*Page*$' ");
			pageSqlId = defaultPageSqlId;
		}
		MappedStatement mappedStatement = (MappedStatement) metaStatementHandler
				.getValue("delegate.mappedStatement");

		// 只重写需要分页的sql语句。通过MappedStatement的ID匹配，默认重写以Page结尾的MappedStatement的sql
		if (mappedStatement.getId().matches(pageSqlId)) {
			
			BoundSql boundSql = (BoundSql) metaStatementHandler.getValue("delegate.boundSql");
			String sql = boundSql.getSql();
			if (mappedStatement.getId().matches(pageSqlId)) {
				Object parameterObject = boundSql.getParameterObject();
				if (parameterObject == null) {
					throw new NullPointerException("parameterObject is null!");
				}
				Connection connection = (Connection) invocation.getArgs()[0];
				PageParameter page = (PageParameter) metaStatementHandler.getValue("delegate.boundSql.parameterObject.page");
						
				// 重设分页参数里的总页数等
				setPageParameter(sql, connection, mappedStatement,
						boundSql, page);
				// 重写sql
				String pageSql = buildPageSql(sql, page);
				metaStatementHandler.setValue("delegate.boundSql.sql",
						pageSql);
				// 重置参数
				metaStatementHandler.setValue("delegate.rowBounds.offset",RowBounds.NO_ROW_OFFSET);
				metaStatementHandler.setValue("delegate.rowBounds.limit",RowBounds.NO_ROW_LIMIT);
			}
		}
		// 将执行权交给下一个拦截器
		return invocation.proceed();
	}

	/**
	 * 从数据库里查询总的记录数并计算总页数，回写进分页参数<code>PageParameter</code>,这样调用者就可用通过 分页参数
	 * <code>PageParameter</code>获得相关信息。
	 * 
	 * @param sql
	 * @param connection
	 * @param mappedStatement
	 * @param boundSql
	 * @param page
	 * @param configuration
	 */
	private void setPageParameter(String sql, Connection connection,
			MappedStatement mappedStatement, BoundSql boundSql,
			PageParameter page) {
		// 统计前去掉sql语句中的order by
		sql = sql.split("order[\\s]+by")[0];
		// 记录总记录数
		String countSql = "select count(1) from (" + sql + ") total";
		PreparedStatement countStmt = null;
		ResultSet rs = null;
		try {
			countStmt = connection.prepareStatement(countSql);
			BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(),
					countSql, boundSql.getParameterMappings(),
					boundSql.getParameterObject());

			// 从原有BoundSql中获取参数映射，设置到count的BoundSql中，这样就可以在配置文件中使用bind标签
			for (ParameterMapping pm : boundSql.getParameterMappings()) {
				String property = pm.getProperty();
				if (null != property && !"".equals(property)) {
					Object value = boundSql.getAdditionalParameter(property);
					if (value != null) {
						countBS.setAdditionalParameter(property, value);
					}
				}
			}

			setParameters(countStmt, mappedStatement, countBS,
					boundSql.getParameterObject());

			rs = countStmt.executeQuery();
			int totalCount = 0;
			if (rs.next()) {
				totalCount = rs.getInt(1);
			}

			page.setTotalCount(totalCount);
			if (page.getCurrentPage() <= 0) {/* 如果当前页 保证至少是第一页 */
				page.setCurrentPage(1);
			}
			if (page.getPageSize() <= 0) {/* 如果输入不合理的每页0条记录或是每页是负数的数字 默认显示10条 */
				page.setPageSize(15);
			}
			int totalPage = totalCount / page.getPageSize()
					+ ((totalCount % page.getPageSize() == 0) ? 0 : 1);
			page.setTotalPage(totalPage);
			// 设置上一页，下一页
			int prePage = page.getCurrentPage() - 1 > 0 ? page.getCurrentPage() - 1
					: 0;
			int nextPage = page.getCurrentPage() + 1;
			page.setPrePage(prePage);
			page.setNextPage(nextPage);

		} catch (SQLException e) {
			logger.error("Ignore this exception", e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception e) {
				logger.error("Ignore this exception", e);
			}
			try {
				if (countStmt != null) {
					countStmt.close();
				}
			} catch (Exception e) {
				logger.error("Ignore this exception", e);
			}
		}
	}

	/**
	 * 对SQL参数(?)设值
	 * 
	 * @param ps
	 * @param mappedStatement
	 * @param boundSql
	 * @param parameterObject
	 * @throws SQLException
	 */
	private void setParameters(PreparedStatement ps,
			MappedStatement mappedStatement, BoundSql boundSql,
			Object parameterObject) throws SQLException {
		ParameterHandler parameterHandler = new DefaultParameterHandler(
				mappedStatement, parameterObject, boundSql);
		parameterHandler.setParameters(ps);
	}

	/**
	 * 根据数据库类型，生成特定的分页sql
	 * 
	 * @param sql
	 * @param page
	 * @return
	 */
	private String buildPageSql(String sql, PageParameter page) {
		if (page != null) {
			boolean resetFlag = (page.getCurrentPage() - 1)
					* page.getPageSize() > page.getTotalCount();
			if (resetFlag || (page.getCurrentPage() > page.getTotalPage())) {
				page.setCurrentPage(page.getTotalPage() == 0 ? 1 : page
						.getTotalPage());
			} else {
				page.setCurrentPage(page.getCurrentPage());
			}

			StringBuilder pageSql = new StringBuilder();
			if ("mysql".equals(dialect)) {
				pageSql = buildPageSqlForMysql(sql, page);
			}else {
				return sql;
			}
			return pageSql.toString();
		} else {
			return sql;
		}
	}

	/**
	 * mysql的分页语句
	 * 
	 * @param sql
	 * @param page
	 * @return String
	 */
	public StringBuilder buildPageSqlForMysql(String sql, PageParameter page) {
		StringBuilder pageSql = new StringBuilder(100);
		String beginrow = String.valueOf((page.getCurrentPage() - 1)
				* page.getPageSize());
		pageSql.append(sql);
		pageSql.append(" limit " + beginrow + "," + page.getPageSize());
		return pageSql;
	}

	@Override
	public Object plugin(Object target) {
		// 当目标类是StatementHandler类型时，才包装目标类，否者直接返回目标本身,减少目标被代理的次数
		if (target instanceof StatementHandler) {
			return Plugin.wrap(target, this);
		} else {
			return target;
		}
	}


	@Override
	public void setProperties(Properties properties) {
		
	}
	


}
