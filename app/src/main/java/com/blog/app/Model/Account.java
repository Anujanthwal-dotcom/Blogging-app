package com.blog.app.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
   
    private String email;

    
    private String password;

    
    private String username;
    private String role="USER";
    //a user may or may not have any post but a post will always have a user
    //one to many mapping

    @OneToMany(mappedBy = "account")
    private List<Post> posts;

    
}
