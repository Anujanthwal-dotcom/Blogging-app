package com.blog.app.Config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.blog.app.Model.Account;
import com.blog.app.Repository.AccountRepository;
@Component
public class CustomUserDetailsService implements UserDetailsService{

   @Autowired
    private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Account user = accountRepository.findByUsername(username);
        
       if(user!=null) {
           return new CustomUser(user);
           
       }else{
           throw new UsernameNotFoundException("User not found");
       }
    }
    
}
