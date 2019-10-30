package com.tayfint.meethub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.tayfint.meethub.model.Meeting;
import com.tayfint.meethub.model.User;
import com.tayfint.meethub.service.MembershipService;

@Controller
@RequestMapping("/Memberships")
public class MembershipController {

static final Logger logger = LoggerFactory.getLogger(MembershipController.class);
	
	@Autowired
	private MembershipService membershipService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String showMembership(@SessionAttribute("user") User user, Model model) {

		Meeting mtg = new Meeting();

		// set default value
		mtg.setName("Simo Guiadem");
		mtg.setShortDesc("This is a short description of this meeting!");
		mtg.setCountryOfIncorp("Cameroon");
		mtg.setCity("Yaounde");
		mtg.setStreetAddr("Ngousso");
		mtg.setIsPublic(true);
		model.addAttribute("meeting", mtg);
		model.addAttribute("memberships", membershipService.findMembershipByUser(user));

		return "fragments/landing::teams";
	}
	
}
