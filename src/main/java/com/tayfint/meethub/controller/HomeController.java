package com.tayfint.meethub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tayfint.meethub.model.User;

@Controller
public class HomeController {

	private final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		logger.debug("index()");
		return "index";
	}
	
	@RequestMapping(value = {"/gettingStarted.html"}, method = RequestMethod.GET)
	public ModelAndView getRegistrationPage(){
		return new ModelAndView("registration", "user", new User());
	}
}
