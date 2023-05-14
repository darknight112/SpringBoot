package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Account;
import com.codeline.sampleProject.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
public class AccountController {
    @Autowired
    AccountService accountService;
    @RequestMapping("account/create")
    public void saveAccount(){
        createAccount();
    }

    @RequestMapping("account/get")
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
