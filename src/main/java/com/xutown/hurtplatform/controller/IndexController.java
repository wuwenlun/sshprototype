package com.xutown.hurtplatform.controller;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wordnik.swagger.annotations.ApiOperation;

/** 
 * 
 * @author kangming.ning [ningkangming@126.com] 
 * 
 */
@Controller
public class IndexController {


	private static final Logger logger = Logger.getLogger(IndexController.class);

	@RequestMapping(value ="/index")
	public ModelAndView index(HttpServletRequest request,
			HttpServletResponse response) {
         
		return new ModelAndView("index");
	}


	@RequestMapping("/")
	public String defaultPage() {

		return "redirect:/index";
	}
	
	@ApiOperation(value="测试接口说明",httpMethod = "GET", response =String.class,notes="接口发布说明")
	@RequestMapping("/test")
	public String test(ModelMap map) {
        map.addAttribute("test1", new Date());
		return "index";
	}

}