package com.xutown.hurtplatform.query;

/**
 * 分页参数类
 * @author kangming.ning
 */
public class PageParameter {

	public static final int DEFAULT_PAGE_SIZE = 15;

	private int pageSize = 15;
	private int currentPage = 1;
	private int prePage = 1;
	private int nextPage = 2;
	private int totalPage = 0;
	private int totalCount = 0;
	private int currentNumber = 0;//从0开始

	public int getCurrentNumber() {
		return currentNumber;
	}

	public void setCurrentNumber(int currentNumber) {
		this.currentNumber = currentNumber;
	}

	public PageParameter() {
		this.currentPage = 1;
		this.pageSize = DEFAULT_PAGE_SIZE;
	}

	public void calculate(PageParameter pageParameter) {
		int total = pageParameter.getTotalCount();
		int currentPage = pageParameter.getCurrentPage();
		int pageSize = pageParameter.getPageSize();
		int currentNumber = (currentPage - 1) * pageSize;
		pageParameter.setCurrentNumber(currentNumber);

		int totalPage = total / pageSize;
		totalPage = total % pageSize == 0 ? totalPage : totalPage + 1;
		pageParameter.setTotalPage(totalPage);
		pageParameter.setTotalCount(total);

		int prePage = currentPage - 1;
		int nextPage = currentPage + 1;
		if (prePage < 1) {
			prePage = currentPage;
		}
		if (nextPage > totalPage) {
			nextPage = totalPage;
		}
		pageParameter.setPrePage(prePage);
		pageParameter.setNextPage(nextPage);
	}

	/**
	 * 
	 * @param currentPage
	 * @param pageSize
	 */
	public PageParameter(int currentPage, int pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	public PageParameter(String currentPage, String pageSize) {
		this.currentPage = Integer.parseInt(currentPage);
		this.pageSize = Integer.parseInt(pageSize);
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
