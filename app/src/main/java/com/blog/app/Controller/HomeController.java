package com.blog.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.blog.app.Model.Post;
import com.blog.app.Service.PostService;

@Controller
public class HomeController {

    @Autowired
    private PostService postService;


    @GetMapping("/")
    public String home(Model model){
        return "home";
    }
    @GetMapping("/blogs")
    public String blogs(Model model){
        List<Post> posts=postService.getAll();
        model.addAttribute("posts",posts);
        return "blogs";
    }

   
}
