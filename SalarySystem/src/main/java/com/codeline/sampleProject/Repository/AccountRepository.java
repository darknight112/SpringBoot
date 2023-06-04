package com.codeline.sampleProject.Repository;
import com.codeline.sampleProject.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT a FROM Account a WHERE a.accountNumber = :accountNumber")
    Account getAccountByAccountNumber(@Param("accountNumber") String accountNumber);

    @Query("SELECT a FROM Account a WHERE a.accountHolderName = :accountHolder")
    Account getAccountByAccountHolderName(@Param("accountHolder") String accountHolderName);
}
