package com.demo.web.controllers;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.bcel.internal.generic.NEW;

@Controller
@RequestMapping(value = "/helloworld")
public class HelloWorldController {

	@RequestMapping(value = "/*", method = { RequestMethod.GET })
	public ModelAndView urlTest() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("urltest");
		return modelAndView;
	}

	@RequestMapping(value = { "/index", "/hello" })
	public ModelAndView index() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", "Hello World!");
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping(value = "/detail/{id}", method = { RequestMethod.GET })
	public ModelAndView getDetail(@PathVariable(value = "id") Integer id) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id", id);
		modelAndView.setViewName("detail");
		return modelAndView;
	}
	//请求参数中名字为字母，年龄为数字
	@RequestMapping(value = "/reg/{name:\\w+}-{age:\\d+}", method = { RequestMethod.GET })
	public ModelAndView regUrlTest(@PathVariable(value = "name") String name,
			@PathVariable(value = "age") Integer age) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name", name);
		modelAndView.addObject("age", age);
		modelAndView.setViewName("regurltest");
		return modelAndView;
	}
		//请求参数中不能有example=AAA
	@RequestMapping(value = "/paramstest", params = "example!=AAA", method = { RequestMethod.GET })
	public ModelAndView paramsTest() {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("paramstest");
		return modelAndView;
	}
}
