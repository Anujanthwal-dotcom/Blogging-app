package com.blog.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.app.Model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    
}
