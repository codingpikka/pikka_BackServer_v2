package com.ohgiraffers.pikka_backserver.post.service;

import com.ohgiraffers.pikka_backserver.post.entity.PostEntity;
import com.ohgiraffers.pikka_backserver.post.model.PostDTO;
import com.ohgiraffers.pikka_backserver.post.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public Map<String, Integer> add(PostDTO postDTO){
        PostEntity postEntity = new PostEntity();
        postEntity.setId(postDTO.getId());
        postEntity.setTitle(postDTO.getTitle());
        postEntity.setContent(postDTO.getContent());
        postEntity.setThumbnail(postDTO.getThumbnail());

        PostEntity savedPostEntity = postRepository.save(postEntity);

        if (Objects.isNull(savedPostEntity)) {
            return null;

        }else {
            return Map.of("postId", savedPostEntity.getId());
        }
    }
}
