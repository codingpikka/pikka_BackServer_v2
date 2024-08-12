package com.ohgiraffers.pikka_backserver.post.controller;


import com.ohgiraffers.pikka_backserver.post.model.PostDTO;
import com.ohgiraffers.pikka_backserver.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostController {

    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // 모든 게시글 조회
    @GetMapping("/post")
    public ResponseEntity<List<PostDTO>> getPosts() {
        List<PostDTO> posts = postService.getAllPosts(); // 데이터베이스에서 모든 게시글을 조회
        return ResponseEntity.ok(posts);
    }

    // 데이터베이스에 새로운 게시글을 추가
    @PostMapping("/post")
    public Map<String, String> post(@RequestBody PostDTO postDTO){
        HashMap<String, String> map = new HashMap<>();
        System.out.println("Received postDTO: " + postDTO);
        postService.add(postDTO);
        // 응답 데이터에 필요한 정보를 추가하거나, 성공 메시지를 담아 반환할 수 있습니다.
        map.put("status", "success message");
        map.put("message", "Data received successfully");
        return map;
    }


    // 특정 id에 대항하는 게시글을 데이터베이스에서 조회하여 반환
    @GetMapping("/post/{id}")
    public ResponseEntity<PostDTO> getPost(@PathVariable Integer id) {
        PostDTO postDTO = postService.getPost(id);
        if (postDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(postDTO);
    }

    // id에 대한 수정
    @PutMapping("/post/{id}")
    public ResponseEntity<PostDTO> updatePost(@PathVariable Integer id, @RequestBody PostDTO postDTO) {
        try {
            PostDTO updatedPost = postService.updatePost(id, postDTO);
            if (updatedPost == null) {
                return ResponseEntity.notFound().build(); // 게시글이 존재하지 않을 경우 404 반환
            }
            return ResponseEntity.ok(updatedPost);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // id에 대한 삭제
    @DeleteMapping("/post/{id}")
    public ResponseEntity<PostDTO> deletePost(@PathVariable Integer id) {
        try {
            PostDTO deletedPost = postService.findPostById(id); // 삭제 전 정보를 가져옴
            postService.deletePostById(id);
            return ResponseEntity.ok(deletedPost);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
