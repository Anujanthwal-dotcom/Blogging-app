package com.blog.app.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.app.Model.Post;
import com.blog.app.Repository.PostRepository;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public Optional<Post> getById(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }

    // if id of a post is null then it has not yet add and hence we give time to the
    // post.
    public void save(Post post) {

        if (post.getId() == null) {
            post.setCreatedAt(LocalDateTime.now());
        }
        postRepository.save(post);
    }
}
