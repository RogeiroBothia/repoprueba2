package com.ufps.seguimientoGraduados.presentation.controller;

import com.ufps.seguimientoGraduados.persistence.entity.Comment;
import com.ufps.seguimientoGraduados.persistence.entity.Post;
import com.ufps.seguimientoGraduados.service.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    //funciona
    @GetMapping("/{userId}")
    public List<Post> myPosts(@PathVariable Long userId) {
        List<Post> myPosts = postService.getPostByUserId(userId);
        return myPosts;
    }

    //funciona
    @PostMapping("/{userId}/createPost")
    public ResponseEntity<String> createPost(@PathVariable Long userId, @RequestBody Post post) {
        postService.createPost(post, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body("1");
    }

    //funciona
    @PutMapping("/{postId}/update")
    public ResponseEntity<String> updatePost(@PathVariable Long postId, @RequestBody Post post) {
        postService.updatePost(postId, post);
        return ResponseEntity.status(HttpStatus.OK).body("1"); }

    //funciona
    @GetMapping("/{postId}/comments") public List<Comment>
    postComments(@PathVariable Long postId) {
        Post post = postService.getPostById(postId).orElseThrow(() -> new IllegalArgumentException("Invalid post id"));
        List<Comment> comments = post.getCommentList();
        return comments;
    }

    //funciona
    @DeleteMapping("/{postId}/delete")
    public ResponseEntity<String> deletePost(@PathVariable Long postId) {
        postService.deletePostById(postId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("1");
    }

    //funciona
    @GetMapping("/allPost")
    public List<Post> homePage() {
        return postService.getAllPost();
    }
}
