package com.ufps.seguimientoGraduados.presentation.controller;

import com.ufps.seguimientoGraduados.persistence.entity.Comment;
import com.ufps.seguimientoGraduados.service.interfaces.CommentService;
import com.ufps.seguimientoGraduados.service.interfaces.PostService;
import com.ufps.seguimientoGraduados.service.interfaces.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/{postId}/addComment/{userId}")
    public ResponseEntity<String> addComment(@PathVariable Long postId, @RequestBody Comment comment, @PathVariable Long userId) {
        commentService.createComment(postId, comment, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body("1");
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateComment(@RequestParam("commentId") Long id, @RequestBody Comment comment) {
        commentService.updateComment(id, comment);
        return ResponseEntity.status(HttpStatus.OK).body("1");
    }

    @DeleteMapping("/delete/{id}") public ResponseEntity<String> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id); return ResponseEntity.status(HttpStatus.NO_CONTENT).body("1");
    }
}