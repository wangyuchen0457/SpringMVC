package com.demo.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/helloworld")
public class HelloWorldController {

	@RequestMapping(value = "/index", method = { RequestMethod.GET })
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

}
