package com.tayfint.meethub.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tayfint.meethub.model.User;
import com.tayfint.meethub.service.UserService;
import com.tayfint.meethub.validator.UserFormValidator;

@Controller
public class UserController {

	static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	UserFormValidator userFormValidator;
	
	@Autowired
    private DaoAuthenticationProvider authenticationManager;

	//Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userFormValidator);
	}

	// list page
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String showAllUsers(Model model) {

		logger.debug("showAllUsers()");
		model.addAttribute("users", userService.findAllUsers());
		return "users/list";

	}

	// save or update user
	// 1. @ModelAttribute bind form value
	// 2. @Validated form validator
	// 3. RedirectAttributes for flash value
	@RequestMapping(value = "/register.go", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("user") @Validated User user,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes, HttpServletRequest request, HttpServletResponse response) {

		logger.debug("saveOrUpdateUser() : {}", user);
		
		if (result.hasErrors()) {
			logger.debug("Binding Errors : {}", result.getAllErrors().get(0));
			//populateDefaultModel(model);
			return "users/userform";
		} else {

			// Add message to flash scope
			/*redirectAttributes.addFlashAttribute("css", "success");
			if(user.isNew()){
			  redirectAttributes.addFlashAttribute("msg", "User added successfully!");
			}else{
			  redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
			}*/

			userService.saveUser(user);
			logger.debug("----  *** Password  : {}", user.getPassword());
			authenticateUserAndSetSession(user, request);

			// POST/REDIRECT/GET
			return "users/account";

			// POST/FORWARD/GET
			// return "user/list";

		}

	}

	// show add user form
	@RequestMapping(value = {"/signUp"}, method = RequestMethod.GET)
	public String showAddUserForm(Model model) {

		logger.debug("showAddUserForm()");

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

		//populateDefaultModel(model);
		return "signup";
	}

	// show update form
	@RequestMapping(value = "/users/{id}/update", method = RequestMethod.GET)
	public String showUpdateUserForm(@PathVariable("id") Long id, Model model) {

		logger.debug("showUpdateUserForm() : {}", id);

		User user = userService.findByUserId(id);
		model.addAttribute("userForm", user);

		//populateDefaultModel(model);

		return "users/userform";

	}

	/*	// delete user
	@RequestMapping(value = "/users/{id}/delete", method = RequestMethod.POST)
	public String deleteUser(@PathVariable("id") long id,
		final RedirectAttributes redirectAttributes) {

		logger.debug("deleteUser() : {}", id);

		userService.delete(id);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "User is deleted!");

		return "redirect:/users";

	}*/

	// show user
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public String showUser(@PathVariable("id") Long id, Model model) {

		logger.debug("showUser() id: {}", id);

		User user = userService.findByUserId(id);
		if (user == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("user", user);

		return "users/show";

	}
	
	 private void authenticateUserAndSetSession(User user, HttpServletRequest request) {
	        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
	        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, user.getPassword(), userDetails.getAuthorities());

	        // generate session if one doesn't exist
	        request.getSession();

	        token.setDetails(new WebAuthenticationDetails(request));
	        Authentication authenticatedUser = authenticationManager.authenticate(token);

	        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
	    }
	
}
