package com.tayfint.meethub.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tayfint.meethub.model.Membership;
import com.tayfint.meethub.model.dto.DepositWithdrawDTO;
import com.tayfint.meethub.service.AccountService;
import com.tayfint.meethub.service.MembershipService;
import com.tayfint.meethub.service.TransactionService;
import com.tayfint.meethub.service.UserService;

@Controller
@RequestMapping("/account")
@SessionAttributes("membership")
public class AccountController {

	@Autowired
	private UserService userService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private MembershipService membershipService;

	@Autowired
	private TransactionService transactionService;

	static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	/*
	 * @RequestMapping("/primaryAccount") public String primaryAccount(Model
	 * model, Principal principal) { List<PrimaryTransaction>
	 * primaryTransactionList =
	 * transactionService.findPrimaryTransactionList(principal.getName());
	 * 
	 * User user = userService.findByUsername(principal.getName());
	 * PrimaryAccount primaryAccount = user.getPrimaryAccount();
	 * 
	 * model.addAttribute("primaryAccount", primaryAccount);
	 * model.addAttribute("primaryTransactionList", primaryTransactionList);
	 * 
	 * return "primaryAccount"; }
	 */

	/*
	 * @RequestMapping("/savingsAccount") public String savingsAccount(Model
	 * model, Principal principal) { List<SavingsTransaction>
	 * savingsTransactionList =
	 * transactionService.findSavingsTransactionList(principal.getName()); User
	 * user = userService.findByUsername(principal.getName()); SavingsAccount
	 * savingsAccount = user.getSavingsAccount();
	 * 
	 * model.addAttribute("savingsAccount", savingsAccount);
	 * model.addAttribute("savingsTransactionList", savingsTransactionList);
	 * 
	 * return "savingsAccount"; }
	 */
	@ModelAttribute("membership")
	public Membership getMembersip() {
		return new Membership();
	}

	@RequestMapping(value = "/deposit", method = RequestMethod.POST)
	public String depositOrWithdrawPOST(@RequestBody DepositWithdrawDTO depositForm,
			@SessionAttribute("membership") Membership membership, Model model) {
		DepositWithdrawDTO dto = new DepositWithdrawDTO();
		logger.debug("************** OperationType: " + depositForm.getOperationType());
		logger.debug("************** Amount: " + depositForm.getAmount());
		if (depositForm.getOperationType().equalsIgnoreCase("deposit")) {
			dto = accountService.deposit(depositForm.getAccountType(),
					Double.parseDouble(depositForm.getAmount().toPlainString()), membership);
		} else {
			dto = accountService.withdraw(depositForm.getAccountType(),
					Double.parseDouble(depositForm.getAmount().toPlainString()), membership);
		}
		logger.debug("************** Transaction Done!!");
		model.addAttribute("depositForm", dto);
		return "fragments/successful_transaction :: depositOrWithdrawal";
	}

	@RequestMapping(value = "/{membershipId}", method = RequestMethod.GET)
	public String showAccount(@PathVariable Long membershipId, @SessionAttribute("userFirstName") String userFirstName, @RequestParam(defaultValue="0") int page, Model model) {

		DepositWithdrawDTO depositForm = new DepositWithdrawDTO();
		model.addAttribute("depositForm", depositForm);

		List<String> AccountTypes = new ArrayList<String>();
		AccountTypes.add("primary");
		AccountTypes.add("savings");
		model.addAttribute("accountTypes", AccountTypes);

		List<String> operationTypes = new ArrayList<String>();
		operationTypes.add("deposit");
		operationTypes.add("withdraw");
		model.addAttribute("operationTypes", operationTypes);

		model.addAttribute("userFirstName", userFirstName);

		logger.debug("************** Membership ID: " + membershipId);
		Membership membership = membershipService.findMembershipById(membershipId);
		model.addAttribute("membership", membership);
		model.addAttribute("primaryTransactionList", transactionService.findPrimaryTransactionList(membership, page));

		return "users/account";
	}
	
	@RequestMapping(value = "/checkingActTrxPage", method = RequestMethod.GET)
	public String getcheckingActTrxPage(@SessionAttribute("membership") Membership membership, @RequestParam(defaultValue="0") int page, Model model) {
		logger.debug("************** Membership ID: " + membership.getId());
		model.addAttribute("primaryTransactionList", transactionService.findPrimaryTransactionList(membership, page));

		return "fragments/transactions_tabs :: checkingActTrxPage";
	}

}
