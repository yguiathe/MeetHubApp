package com.tayfint.meethub.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tayfint.meethub.model.Meeting;
import com.tayfint.meethub.service.MeetingService;

@Controller
public class MeetingController {

	static final Logger logger = LoggerFactory.getLogger(MeetingController.class);
	
	@Autowired
	private MeetingService meetingService;
	
	@RequestMapping(value = "/newMeeting.go", method = RequestMethod.POST)
	public String saveMeeting(@ModelAttribute("meetingForm") Meeting meeting,
			BindingResult result, Model model, final RedirectAttributes redirectAttributes, HttpServletRequest request, HttpServletResponse response) {
		
		if (result.hasErrors()) {
			logger.debug("Binding Errors : {}", result.getAllErrors().get(0));
			//populateDefaultModel(model);
			return "User/Memberships";
		} else {
			meetingService.saveMeeting(meeting);
			redirectAttributes.addFlashAttribute("meeting", meeting);

			// POST/REDIRECT/GET
			return "redirect:Memberships";
		}

	}
	
}
