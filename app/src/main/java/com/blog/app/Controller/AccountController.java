package com.blog.app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.blog.app.Model.Account;
import com.blog.app.Service.AccountService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {
    
    @Autowired
    private AccountService accountService;


    @GetMapping("/register")////this method creates a new account object and push it in the frontend.
    public String register(Model model){
        Account account=new Account();
        model.addAttribute("account",account);
        return "register";
    }

    @PostMapping("/register")
    public String register_user(@ModelAttribute Account account) {
        accountService.save(account);
        return "redirect:/";
    }

    @GetMapping("/signin")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/error")
    public String loginError(Model model) {
        
        return "error";
    }

    
}
