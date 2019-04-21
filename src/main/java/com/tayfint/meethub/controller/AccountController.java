package com.tayfint.meethub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.tayfint.meethub.model.Account;
import com.tayfint.meethub.model.dto.AccountDto;
import com.tayfint.meethub.service.AccountService;

@Controller
@RequestMapping("/User/Accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

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

	@RequestMapping(value = "/deposit/{toAccountId}", method = RequestMethod.POST)
	public String deposit(@RequestBody AccountDto acctDto,
			@PathVariable Long toAccountId, Model model) {
		logger.debug("************** Amount: " + acctDto.getBalance());
		Account act = accountService.deposit(accountService.findById(toAccountId), acctDto.getBalance());
		logger.debug("************** Deposit Done!!");
		model.addAttribute("acctDto", new AccountDto(act.getBalance(), act.getAccountNumber(), act.getAcctType(), act.isActive()));
		return "fragments/successful_transaction :: depositOrWithdrawal";
	}
	
	@RequestMapping(value = "/withdraw/{fromAccountId}", method = RequestMethod.POST)
	public String withdraw(@RequestBody AccountDto acctDto,
			@PathVariable Long fromAccountId, Model model) {
		logger.debug("************** Amount: " + acctDto.getBalance());
		Account act = accountService.withdraw(accountService.findById(fromAccountId), acctDto.getBalance());
		logger.debug("************** Withdrawal Done!!");
		model.addAttribute("acctDto", new AccountDto(act.getBalance(), act.getAccountNumber(), act.getAcctType(), act.isActive()));
		return "fragments/successful_transaction :: depositOrWithdrawal";
	}
	
	@RequestMapping(value = "/{acctId}", method = RequestMethod.GET)
	public String showAccount(@PathVariable Long acctId, Model model) {
		
		return "fragments/account :: acct_details";
	}

	/*@RequestMapping(value = "/{membershipId}", method = RequestMethod.GET)
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
	}*/
	
	/*@RequestMapping(value = "/checkingActTrxPage", method = RequestMethod.GET)
	public String getcheckingActTrxPage(@SessionAttribute("membership") Membership membership, @RequestParam(defaultValue="0") int page, Model model) {
		logger.debug("************** Membership ID: " + membership.getId());
		model.addAttribute("primaryTransactionList", transactionService.findPrimaryTransactionList(membership, page));

		return "fragments/transactions_tabs :: checkingActTrxPage";
	}*/

}
