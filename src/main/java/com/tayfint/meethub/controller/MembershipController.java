package com.tayfint.meethub.controller;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tayfint.meethub.model.Meeting;
import com.tayfint.meethub.model.User;
import com.tayfint.meethub.service.MembershipService;
import com.tayfint.meethub.service.UserService;

@Controller
@SessionAttributes("userFirstName")
public class MembershipController {

	static final Logger logger = LoggerFactory.getLogger(MembershipController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MembershipService membershipService;
	
	@RequestMapping(value = "/saveMembership.go", method = RequestMethod.POST)
	public String saveMembership(@ModelAttribute("meetingForm") Meeting meeting,
			BindingResult result, Principal principal, final RedirectAttributes redirectAttributes, HttpServletRequest request, HttpServletResponse response) {
		if (result.hasErrors()) {
			logger.debug("Binding Errors : {}", result.getAllErrors().get(0));
			//populateDefaultModel(model);
			return "users/membership";
		} else {
			membershipService.saveMembership(meeting, userService.findByUsername(principal.getName()));
			// POST/REDIRECT/GET
			return "redirect:my_memberships.go";
		}
	}
	
	@RequestMapping(value = "/my_memberships.go", method = RequestMethod.GET)
	public String showMembership(Principal principal, Model model) {

		Meeting mtg = new Meeting();

		// set default value
		mtg.setName("Simo Guiadem");
		mtg.setShortDesc("This is a short description of this meeting!");
		mtg.setCountryOfIncorp("Cameroon");
		model.addAttribute("meetingForm", mtg);
		User user = userService.findByUsername(principal.getName());
		model.addAttribute("userFirstName", user.getFirstName());
		model.addAttribute("memberships", membershipService.findMembershipByUser(user));

		return "users/membership";
	}
	
}
