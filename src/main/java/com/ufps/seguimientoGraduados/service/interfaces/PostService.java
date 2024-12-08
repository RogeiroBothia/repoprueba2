package com.ufps.seguimientoGraduados.service.interfaces;

import com.ufps.seguimientoGraduados.persistence.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getAllPost();
    Optional<Post> getPostById(Long id);
    List<Post> getPostByUserId(Long userId);
    void createPost(Post post, Long userId);
    void updatePost(Long id, Post post);
    void deletePostById(Long id);

    void activePost(Long postId);
}
