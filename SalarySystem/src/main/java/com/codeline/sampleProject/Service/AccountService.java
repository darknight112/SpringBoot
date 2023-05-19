package com.codeline.sampleProject.Service;
import com.codeline.sampleProject.Models.Account;
import com.codeline.sampleProject.Models.Employee;
import com.codeline.sampleProject.Repository.AccountRepository;
import com.codeline.sampleProject.ResponseObjects.GetAccountResponse;
import com.codeline.sampleProject.ResponseObjects.GetEmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    public List<Account> getAccount(){
        return accountRepository.findAll();
    }
    @Autowired
    AccountRepository accountRepository;
    public void saveAccount(Account account){
        accountRepository.save(account);
    }



    public GetAccountResponse getAccountById(Long accountId) {
        Optional<Account> optionalAccount =  accountRepository.findById(accountId);
        if(!optionalAccount.isEmpty())
        {
            Account account =  optionalAccount.get();
            GetAccountResponse accountResponse = new GetAccountResponse(account.getAccountHolderName(),account.getBankName());
            return accountResponse;
        }


        return null;

    }

}
