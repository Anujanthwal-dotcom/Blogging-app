package com.blog.app.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name="title")
    private String title;
    
    @Column(columnDefinition="TEXT")
    private String text;
    
    @Column()
    private LocalDateTime createdAt;

    //every post can have many users
    @ManyToOne
    @JoinColumn(name="account_id",referencedColumnName = "id",nullable=true)//we don't want to have a post without user. this column store the user id in it.
    private Account account;

}
