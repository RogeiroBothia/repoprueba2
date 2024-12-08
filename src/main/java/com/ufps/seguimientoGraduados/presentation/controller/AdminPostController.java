package com.ufps.seguimientoGraduados.presentation.controller;

import com.ufps.seguimientoGraduados.persistence.entity.Post;
import com.ufps.seguimientoGraduados.persistence.repository.PostRepository;
import com.ufps.seguimientoGraduados.service.interfaces.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/post")
public class AdminPostController {

    @Autowired
    private PostService postService;

    @GetMapping()
    public List<Post> postNoActivated(){
        return postService.ffindByActivePostFalse();
    }

    @PutMapping("/{postId}")
    public ResponseEntity<String> activarPost(@PathVariable Long postId){
        postService.activePost(postId);
        return ResponseEntity.status(HttpStatus.OK).body("1");
    }

}
