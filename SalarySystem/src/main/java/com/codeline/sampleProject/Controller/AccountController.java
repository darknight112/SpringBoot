package com.codeline.sampleProject.Controller;
import com.codeline.sampleProject.Models.Account;
import com.codeline.sampleProject.Models.Employee;
import com.codeline.sampleProject.RequestObjects.GetAccountRequestObject;
import com.codeline.sampleProject.RequestObjects.GetEmployeeRequestObject;
import com.codeline.sampleProject.ResponseObjects.GetAccountResponse;
import com.codeline.sampleProject.ResponseObjects.GetEmployeeResponse;
import com.codeline.sampleProject.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;


import java.util.Date;
import java.util.List;
@RestController
public class AccountController {
    @Autowired
    AccountService accountService;
    @PostMapping("account/create")
    public void saveAccount (@RequestBody GetAccountRequestObject accountRequestObject) {
        createAccount(accountRequestObject);
    }

    @GetMapping("account/get")
    public List<Account> getAccount () {
        return accountService.getAccount();
    }
//update

    //Path Variable
    @RequestMapping("account/get/{accountId}")
    public GetAccountResponse createAccount (@PathVariable Long accountId) {
        return accountService.getAccountById(accountId);
    }
    public void createAccount(GetAccountRequestObject accountRequestObject) {
        Account account = new Account();
        RandomNumberGenerator random = new RandomNumberGenerator();
        account.setAccountType("Saving");
        account.setAccountNumber(random.toString());
        account.setAccountHolderName(accountRequestObject.getName());
        account.setCreatedDate(new Date());
        account.setIsActive(true);
        account.setBankName(accountRequestObject.getBankName());
        account.setBankBranch("Al Khoud");
        account.setSwiftCode("Y23123");
        account.setUpdatedDate(new Date());
        accountService.saveAccount(account);
    }

    public class RandomNumberGenerator {
        public static long generateRandomNumber() {
            Random random = new Random();
            long min = 1000000000L; // 10-digit minimum value
            long max = 9999999999L; // 10-digit maximum value
            return random.nextLong() % (max - min + 1) + min;
        }
    }

}
