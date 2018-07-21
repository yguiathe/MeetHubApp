package com.tayfint.meethub.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tayfint.meethub.model.Meeting;
import com.tayfint.meethub.model.Membership;
import com.tayfint.meethub.model.UserDetailsImpl;
import com.tayfint.meethub.service.MembershipService;

@Controller
public class MembershipController {

	static final Logger logger = LoggerFactory.getLogger(MembershipController.class);
	
	@Autowired
	private MembershipService membershipService;
	
	@RequestMapping(value = "/membership.go", method = RequestMethod.GET)
	public String saveMembership(@ModelAttribute("meeting") Meeting meeting,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes, HttpServletRequest request, HttpServletResponse response) {
		if (result.hasErrors()) {
			logger.debug("Binding Errors : {}", result.getAllErrors().get(0));
			//populateDefaultModel(model);
			return "users/membership";
		} else {
			
			Membership membership = new Membership();
			membership.setAppMeeting(meeting);
			UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			membership.setAppUser(userDetails.getUser());
			membershipService.saveMembership(membership);

			// POST/REDIRECT/GET
			return "redirect:users/membership";
		}
	}
}
