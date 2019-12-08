package com.tayfint.meethub.controller;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tayfint.meethub.model.Account;
import com.tayfint.meethub.model.Meeting;
import com.tayfint.meethub.model.Membership;
import com.tayfint.meethub.model.User;
import com.tayfint.meethub.model.dto.UserDto;
import com.tayfint.meethub.service.AccountService;
import com.tayfint.meethub.service.MembershipService;

@Controller
@SessionAttributes({ "membership" })
@RequestMapping("/memberships")
public class MembershipController {

	static final Logger logger = LoggerFactory.getLogger(MembershipController.class);

	@Autowired
	private MembershipService membershipService;

	@Autowired
	private AccountService acctService;

	@Autowired
	private ModelMapper mm;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String getAllMembershipsByUser(@SessionAttribute("user") User user, Model model) {

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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getMembershipDetailsById(@PathVariable("id") Long membershipId, @SessionAttribute("user") User user,
			Model model) {
		logger.debug("Membership: " + membershipId);
		BigDecimal checkingBal = new BigDecimal("0");
		BigDecimal savingBal = new BigDecimal("0");
		BigDecimal loanBal = new BigDecimal("0");
		BigDecimal investmentBal = new BigDecimal("0");
		model.addAttribute("userDto", mm.map(user, UserDto.class));
		Membership membership = membershipService.findMembershipById(membershipId).get();
		model.addAttribute("membership", membership);
		model.addAttribute("user", user);
		for (Account account : acctService.findByMembership(membership)) {
			switch (account.getAcctType()) {
			case "CHK":
				checkingBal = checkingBal.add(account.getBalance());
				break;
			case "SAV":
				savingBal = savingBal.add(account.getBalance());
				break;
			case "LOA":
				loanBal = loanBal.add(account.getBalance());
				break;
			case "INV":
				investmentBal = investmentBal.add(account.getBalance());
				break;
			}
		}
		model.addAttribute("checkingBal", checkingBal);
		model.addAttribute("savingBal", savingBal);
		model.addAttribute("loanBal", loanBal);
		model.addAttribute("investmentBal", investmentBal);
		return "User/meeting";
	}
}
