package com.blog.app.Config;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.blog.app.Model.Account;
import com.blog.app.Model.Post;
import com.blog.app.Service.AccountService;
import com.blog.app.Service.PostService;

@Component
public class SeedData implements CommandLineRunner{
    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

   

    @Override
    public void run(String... args) throws Exception {
        Account account1=new Account();
        Account account2=new Account();

        account1.setUsername("Anuj");
        account1.setPassword("1234");
        account1.setEmail("anuj@gmail.com");
        account1.setRole("ROLE_USER");
        account2.setUsername("Sammy");
        account2.setPassword("12345");
        account2.setEmail("jon@gmail.com");
        account2.setRole("ROLE_USER");

        accountService.save(account1);
        accountService.save(account2);


        List<Post> posts=postService.getAll();
        if(posts.size()==0){
            Post post01=new Post();
            post01.setTitle("Post01");
            post01.setText("post 1.............");
            post01.setAccount(account1);
            postService.save(post01);

            Post post02=new Post();
            post02.setTitle("Post02");
            post02.setText("post 2.............");
            post02.setAccount(account2);
            postService.save(post02);
        }
    }
    
}
