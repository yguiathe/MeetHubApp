package com.tayfint.meethub.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tayfint.meethub.dao.RoleDao;
import com.tayfint.meethub.model.User;
import com.tayfint.meethub.model.security.UserRole;
import com.tayfint.meethub.service.SecurityService;
import com.tayfint.meethub.service.UserService;
import com.tayfint.meethub.validator.UserFormValidator;

@Controller
public class UserController {

	static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	UserFormValidator userFormValidator;
	
	@Autowired
    private SecurityService securityService;
	
	@Autowired
    private RoleDao roleDao;

	//Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(userFormValidator);
	}

	// list page
	@RequestMapping(value = "/Users", method = RequestMethod.GET)
	public String showAllUsers(Model model) {

		logger.debug("showAllUsers()");
		model.addAttribute("users", userService.findUserList());
		return "users/list";

	}

	// save or update user
	// 1. @ModelAttribute bind form value
	// 2. @Validated form validator
	// 3. RedirectAttributes for flash value
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated User user,
			BindingResult result, Model model,
			final RedirectAttributes redirectAttributes, HttpServletRequest request, HttpServletResponse response) {
		
		if (result.hasErrors()) {
			logger.debug("Binding Errors : {}", result.getAllErrors().get(0));
			//populateDefaultModel(model);
			return "signup";
		} else if(userService.checkUserExists(user.getUsername(), user.getEmail())){
			 if (userService.checkEmailExists(user.getEmail())) {
	                model.addAttribute("emailExists", true);
	            }

	            if (userService.checkUsernameExists(user.getUsername())) {
	                model.addAttribute("usernameExists", true);
	            }

	            return "signup";
		} else {

			// Add message to flash scope
			/*redirectAttributes.addFlashAttribute("css", "success");
			if(user.isNew()){
			  redirectAttributes.addFlashAttribute("msg", "User added successfully!");
			}else{
			  redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
			}*/
			
			Set<UserRole> userRoles = new HashSet<>();
            userRoles.add(new UserRole(user, roleDao.findByName("ROLE_USER")));
			userService.createUser(user, userRoles);
			securityService.autologin(user.getUsername(), user.getPassword());

			return "redirect:User/Memberships";

		}

	}

	// show add user form
	@RequestMapping(value = {"/registration"}, method = RequestMethod.GET)
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
		model.addAttribute("userForm", user);

		//populateDefaultModel(model);
		return "signup";
	}
	
}
