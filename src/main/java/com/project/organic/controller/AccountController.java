package com.project.organic.controller;

import com.project.organic.model.Account;
import com.project.organic.respository.AccountRespository;
import com.project.organic.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    AccountRespository accountRespository;
    private final AccountService accountService;


    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.findAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);

    }
    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") int id) {
    	Account account = accountService.findAccountByID(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    @GetMapping("/accounts/email/{email}")
    public ResponseEntity<Account> getAccountByEmail(@PathVariable("email") String email) {
    	Account account = accountService.findAccountByEmail(email);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    @PostMapping("/accounts")
    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
    	Account newaccount = accountService.addAccount(account);
        return new ResponseEntity<>(newaccount, HttpStatus.CREATED);
    }
    @PutMapping("/accounts/update")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
    	Account updateaccount = accountService.updateAccount(account);
        return new ResponseEntity<>(updateaccount, HttpStatus.OK);
    }
    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable("id") int id) {
        if (accountService.findAccountByID(id)!=null){
        	accountService.deleteAccount(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
