package com.project.organic.service;

import com.project.organic.model.Account;
import com.project.organic.model.Account;
import com.project.organic.respository.AccountRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AccountService {
    private final AccountRespository  accountRespository;

    @Autowired
    public AccountService(AccountRespository accountRespository) {
        this.accountRespository = accountRespository;
    }
    public List<Account> findAllAccounts() {
        return accountRespository.findAll();
    }
    public Account updateAccount(Account account) {
        return accountRespository.save(account);
    }
    public void deleteAccount(int id){
    	accountRespository.deleteById(id);
    }
    public Account addAccount(Account Account) {
        return accountRespository.save(Account);
    }
    public Account findAccountByID(int id){
        return accountRespository.findById(id);
    }
    public Account findAccountByEmail(String email){
        return accountRespository.findByEmail(email);
    }

}
