package com.tayfint.meethub.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.PathVariable;

import com.tayfint.meethub.model.Membership;
import com.tayfint.meethub.model.PrimaryAccount;
import com.tayfint.meethub.model.PrimaryTransaction;
import com.tayfint.meethub.model.SavingsAccount;
import com.tayfint.meethub.model.SavingsTransaction;
import com.tayfint.meethub.model.User;
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
	
	/*@RequestMapping("/primaryAccount")
	public String primaryAccount(Model model, Principal principal) {
		List<PrimaryTransaction> primaryTransactionList = transactionService.findPrimaryTransactionList(principal.getName());
		
		User user = userService.findByUsername(principal.getName());
        PrimaryAccount primaryAccount = user.getPrimaryAccount();

        model.addAttribute("primaryAccount", primaryAccount);
        model.addAttribute("primaryTransactionList", primaryTransactionList);
		
		return "primaryAccount";
	}*/

	/*@RequestMapping("/savingsAccount")
    public String savingsAccount(Model model, Principal principal) {
		List<SavingsTransaction> savingsTransactionList = transactionService.findSavingsTransactionList(principal.getName());
        User user = userService.findByUsername(principal.getName());
        SavingsAccount savingsAccount = user.getSavingsAccount();

        model.addAttribute("savingsAccount", savingsAccount);
        model.addAttribute("savingsTransactionList", savingsTransactionList);

        return "savingsAccount";
    }*/
	@ModelAttribute("membership")
	public Membership getMembersip(){
		return new Membership();
	}

    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public String depositOrWithdrawPOST(@ModelAttribute("amount") String amount, @ModelAttribute("accountType") String accountType, @ModelAttribute("operationType") String operationType, @SessionAttribute("membership") Membership membership) {
    	if(operationType.equalsIgnoreCase("Deposit")){
    		accountService.deposit(accountType, Double.parseDouble(amount), membership);
    	} else {
    		accountService.withdraw(accountType, Double.parseDouble(amount), membership);
    	}
        return "redirect:users/account";
    }
    
    @RequestMapping(value = "/{membershipId}", method = RequestMethod.GET)
	public String showAccount(@PathVariable Long membershipId, @ModelAttribute("membership") Membership membership, Principal principal, Model model) {

		populateDefaultModel(model);
		logger.debug("************** Membership ID: " + membershipId);
		membership = membershipService.findMembershipById(membershipId);
		model.addAttribute("membership", membership);

		return "users/account";
	}
    
    private void populateDefaultModel(Model model){
    	
    	List<String> AccountTypes = new ArrayList<String>();
    	AccountTypes.add("Primary");
    	AccountTypes.add("Savings");
    	model.addAttribute("accountTypes", AccountTypes);
    	
    	List<String> operationTypes = new ArrayList<String>();
    	operationTypes.add("deposit");
    	operationTypes.add("withdraw");
        model.addAttribute("operationTypes", operationTypes);
    }
}
