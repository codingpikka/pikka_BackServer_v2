package com.ohgiraffers.pikka_backserver.post.controller;


import com.ohgiraffers.pikka_backserver.post.model.PostDTO;
import com.ohgiraffers.pikka_backserver.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post")
    public Map<String, String> post(){
        HashMap<String, String> map = new HashMap<>();
        return map;
    }

    @PostMapping("/post")
    public Map<String, String> post(@RequestBody PostDTO postDTO){
        HashMap<String, String> map = new HashMap<>();
        postService.add(postDTO);
        return map;
    }
}
