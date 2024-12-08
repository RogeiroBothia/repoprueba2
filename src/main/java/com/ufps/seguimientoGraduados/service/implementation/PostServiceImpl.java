package com.ufps.seguimientoGraduados.service.implementation;

import com.ufps.seguimientoGraduados.persistence.entity.Post;
import com.ufps.seguimientoGraduados.persistence.repository.PostRepository;
import com.ufps.seguimientoGraduados.service.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPost() {
      return postRepository.findByActivePostTrue();
    }

    @Override
    public Optional<Post> getPostById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> getPostByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }

    @Override
    public void createPost(Post post, Long userId) {
        post.setCreatedAt(LocalDateTime.now());
        post.setActivePost(false);
        post.setUserId(userId);
        postRepository.save(post);
    }

    @Override
    public void updatePost(Long id, Post post) {
        Post postDB = getPostById(id).orElseThrow(() -> new RuntimeException("Invalid post id"));
        postDB.setTitle(post.getTitle());
        postDB.setContent(post.getContent());
        postRepository.save(postDB);
    }

    @Override
    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void activePost(Long postId){
        Post postDB = getPostById(postId).orElseThrow(() -> new RuntimeException("Invalid post id"));
        postDB.setActivePost(true);
        postRepository.save(postDB);
    }

    @Override
    public List<Post> noActivePost(){
        return postRepository.findByActivePostFalse();
    }
}
