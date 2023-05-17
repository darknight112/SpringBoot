package com.codeline.sampleProject.Controller;
import com.codeline.sampleProject.Models.Account;
import com.codeline.sampleProject.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
@RestController
public class AccountController {
    @Autowired
    AccountService accountService;
    @PostMapping("account/create")
    public void saveAccount(){
        createAccount();
    }
    @GetMapping("account/get")
    public List<Account> getAccounts () {
        List<Account> accounts =  accountService.getAccount();
        return accounts;
    }
    public void createAccount() {
        Account account = new Account();
        account.setAccountType("Saving");
        account.setAccountNumber("55258852");
        account.setAccountHolderName("Abdullah");
        account.setCreatedDate(new Date());
        account.setIsActive(true);
        account.setBankName("Bank Muscat");
        account.setBankBranch("Al Khoud");
        account.setSwiftCode("Y23123");
        account.setUpdatedDate(new Date());
        accountService.saveAccount(account);
    }
}
