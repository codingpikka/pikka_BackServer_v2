package com.ohgiraffers.pikka_backserver.post.service;

import com.ohgiraffers.pikka_backserver.post.entity.PostEntity;
import com.ohgiraffers.pikka_backserver.post.model.PostDTO;
import com.ohgiraffers.pikka_backserver.post.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PostService {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public Map<String, Integer> add(PostDTO postDTO) {
        PostEntity postEntity = new PostEntity();
        postEntity.setId(postDTO.getId());
        postEntity.setTitle(postDTO.getTitle());
        postEntity.setThumbnail(postDTO.getThumbnail());
        postEntity.setContent(postDTO.getContent());

        String currentTime = LocalDateTime.now().format(DATE_FORMATTER);
        postEntity.setCreateAt(currentTime);

        PostEntity savedPostEntity = postRepository.save(postEntity);

        if (Objects.isNull(savedPostEntity)) {
            return null;
        } else {
            return Map.of("postId", savedPostEntity.getId());
        }
    }

    public List<PostDTO> getAllPosts() {
        List<PostEntity> posts = postRepository.findAll();
        return posts.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PostDTO findPostById(Integer id) {
        PostEntity postEntity = postRepository.findById(id).orElse(null);
        return postEntity != null ? convertToDTO(postEntity) : null;
    }

    public PostDTO getPost(Integer id) {
        return findPostById(id);
    }

    @Transactional
    public PostDTO updatePost(Integer id, PostDTO postDTO) {
        PostEntity postEntity = postRepository.findById(id).orElse(null);
        if (postEntity == null) {
            return null;
        }

        postEntity.setTitle(postDTO.getTitle());
        postEntity.setThumbnail(postDTO.getThumbnail());
        postEntity.setContent(postDTO.getContent());

        String currentTime = LocalDateTime.now().format(DATE_FORMATTER);
        postEntity.setCreateAt(currentTime);

        PostEntity updatedPostEntity = postRepository.save(postEntity);
        return convertToDTO(updatedPostEntity);
    }

    public void deletePostById(Integer id) {
        postRepository.deleteById(id);
    }

    private PostDTO convertToDTO(PostEntity postEntity) {
        PostDTO dto = new PostDTO();
        dto.setId(postEntity.getId());
        dto.setTitle(postEntity.getTitle());
        dto.setThumbnail(postEntity.getThumbnail());
        dto.setContent(postEntity.getContent());
        dto.setCreateAt(postEntity.getCreateAt());
        return dto;
    }
}