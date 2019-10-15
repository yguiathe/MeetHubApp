package com.tayfint.meethub.controller;

import java.security.Principal;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tayfint.meethub.model.User;
import com.tayfint.meethub.model.dto.UserDto;
import com.tayfint.meethub.service.UserService;

@Controller
public class HomeController {

	private final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper mm;

	@RequestMapping("/")
	public String home() {
		return "redirect:/index";
	}

	@RequestMapping("/index")
	public String index(Model model) {
		logger.debug("Displaying home page!");
		
		User user = new User();
		// set default value
		user.setFirstName("John");
		user.setEmail("test@gmail.com");
		user.setLastName("Doe");
		user.setPrimaryId("1234653");
		user.setGender("M");
		user.setPrimaryIdType("Passport");
		user.setCitizenship("Cameroonian");
		
		model.addAttribute("user", user);
		return "index";
	}
	
	@RequestMapping("/home")
	public String home(Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		model.addAttribute("user", mm.map(user, UserDto.class));
		return "home";
	}

}