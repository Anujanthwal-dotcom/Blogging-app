package com.blog.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.app.Model.Account;
import com.blog.app.Repository.AccountRepository;

@Service
public class AccountService

 {
    @Autowired
    private AccountRepository accountRepository;

    
    
    public void save(Account account){
       account.setPassword(new BCryptPasswordEncoder().encode(account.getPassword()));
        accountRepository.save(account);
    }



    public List<Account> getAll() {

        return accountRepository.findAll();
    }



    
    
    

    
}
