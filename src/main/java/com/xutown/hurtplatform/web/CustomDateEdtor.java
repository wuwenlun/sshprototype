package com.xutown.hurtplatform.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 日期转换器
 */
public class CustomDateEdtor implements Converter<String, Date> {

	/* (non-Javadoc)
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	@Override
	public Date convert(String source) {
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
		    dateFormat.setLenient(false);    
		    try {    
		        return dateFormat.parse(source);    
		    } catch (ParseException e) {    
		        e.printStackTrace();    
		    }           
		    return null;
	}
}