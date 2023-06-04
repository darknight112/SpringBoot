package com.codeline.sampleProject.Controller;

import com.codeline.sampleProject.Models.Account;
import com.codeline.sampleProject.RequestObjects.GetAccountRequestObject;
import com.codeline.sampleProject.ResponseObjects.GetAccountResponse;
import com.codeline.sampleProject.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value = "account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("create")
    public void saveAccount (@RequestParam String name, @RequestParam String bankName) {

        GetAccountRequestObject obj = new GetAccountRequestObject();
        obj.setName(name);
        obj.setBankName(bankName);
        accountService.createAccount(obj);
    }

    @GetMapping("get")
    public List<Account> getAccount () {
        return accountService.getAccount();
    }
//update

    //Path Variable
    @RequestMapping("get/{accountId}")
    public GetAccountResponse createAccount (@PathVariable Long accountId) {
        return accountService.getAccountById(accountId);
    }

        public static Long generateRandomNumber() {
            Random random = new Random();
            long min = 1000000000L; // 10-digit minimum value
            long max = 9999999999L; // 10-digit maximum value
            return random.nextLong() % (max - min + 1) + min;
        }
    @GetMapping("getAccountByName")
    public Account getAccountByName(@RequestParam String accountName){
        return accountService.getAccountByAccountHolderName(accountName);
    }

    @GetMapping("getAccountByNumber")
    public Account getAccountByNumber(@RequestParam String accountNumber){
        return accountService.getAccountByAccountNumber(accountNumber);
    }

}
