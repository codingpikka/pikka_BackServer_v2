package com.ohgiraffers.pikka_backserver.post.service;

import com.ohgiraffers.pikka_backserver.post.entity.PostEntity;
import com.ohgiraffers.pikka_backserver.post.model.PostDTO;
import com.ohgiraffers.pikka_backserver.post.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    // 게시글 등록
    public Map<String, Integer> add(PostDTO postDTO){
        PostEntity postEntity = new PostEntity();
        postEntity.setId(postDTO.getId());
        postEntity.setTitle(postDTO.getTitle());
        postEntity.setThumbnail(postDTO.getThumbnail());
        postEntity.setContent(postDTO.getContent());

        PostEntity savedPostEntity = postRepository.save(postEntity);

        if (Objects.isNull(savedPostEntity)) {
            return null;

        }else {
            return Map.of("postId", savedPostEntity.getId());
        }
    }

    // 전체 게시글 조회
    public List<PostDTO> getAllPosts()  {
        List<PostEntity> posts = postRepository.findAll();
        return posts.stream()
                .map(post -> {
                    PostDTO dto = new PostDTO();
                    dto.setId(post.getId());
                    dto.setTitle(post.getTitle());
                    dto.setThumbnail(post.getThumbnail());
                    dto.setContent(post.getContent());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    // id에 따른 특성 게시글 조회
    public PostDTO findPostById(Integer id) {
        PostEntity postEntity = postRepository.findById(id).orElse(null);

        if (postEntity == null) {
            // 존재하지 않는 경우 null 반환
            return null;
        }
        // DTO 객체를 직접 생성
        PostDTO postDTO = new PostDTO();
        postDTO.setId(postEntity.getId());
        postDTO.setTitle(postEntity.getTitle());
        postDTO.setThumbnail(postEntity.getThumbnail());
        postDTO.setContent(postEntity.getContent());

        return postDTO;
    }

    public PostDTO getPost(Integer id) {
        PostEntity postEntity = postRepository.findById(id).orElse(null);
        if (postEntity == null) {
            return null;
        }

        PostDTO postDTO = new PostDTO();
        postDTO.setId(postEntity.getId());
        postDTO.setTitle(postEntity.getTitle());
        postDTO.setContent(postEntity.getContent());
//        postDTO.setAuthor(postEntity.getAuthor());
//        postDTO.setDate(postEntity.getDate());

        return postDTO;
    }

    public PostDTO updatePost(Integer id, PostDTO postDTO) {
        PostEntity postEntity = postRepository.findById(id).orElse(null);
        if (postEntity == null) {
            // 게시글이 존재하지 않으면 null 반환
            return null;
        }

        // 기존 엔티티의 필드 수정
        postEntity.setTitle(postDTO.getTitle());
        postEntity.setThumbnail(postDTO.getThumbnail());
        postEntity.setContent(postDTO.getContent());

        // 엔티티 저장
        PostEntity updatedPostEntity = postRepository.save(postEntity);

        // DTO 객체 직접 생성
        PostDTO updatedPostDTO = new PostDTO();
        updatedPostDTO.setId(updatedPostEntity.getId());
        updatedPostDTO.setTitle(updatedPostEntity.getTitle());
        updatedPostDTO.setThumbnail(updatedPostEntity.getThumbnail());
        updatedPostDTO.setContent(updatedPostEntity.getContent());

        return updatedPostDTO;
    }

    //id의 따라 삭제하는 메소드
    public void deletePostById(Integer id) {
        postRepository.deleteById(id);
    }
}
