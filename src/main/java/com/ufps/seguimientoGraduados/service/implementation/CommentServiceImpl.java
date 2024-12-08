package com.ufps.seguimientoGraduados.service.implementation;

import com.ufps.seguimientoGraduados.persistence.entity.Comment;
import com.ufps.seguimientoGraduados.persistence.repository.CommentRepository;
import com.ufps.seguimientoGraduados.persistence.repository.PostRepository;
import com.ufps.seguimientoGraduados.service.interfaces.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

public class CommentServiceImpl implements CommentService {
    @Autowired private CommentRepository commentRepository;

    @Autowired private PostRepository postRepository; // Necesitamos esto para verificar la existencia del post

    @Override public
    Optional<Comment> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void createComment(Long postId, Comment comment, Long userId) {
        if (!postRepository.existsById(postId)) {
            throw new RuntimeException("Invalid post id");
        }
        comment.setCreatedAt(LocalDateTime.now());
        comment.setUserId(userId); comment.setPostId(postId);
        commentRepository.save(comment);
    }

    @Override public void updateComment(Long id, Comment comment) {
        Comment commentDB = getCommentById(id).orElseThrow(() -> new RuntimeException("Invalid comment id"));
        commentDB.setContent(comment.getContent());
        commentRepository.save(commentDB);
    }

    @Override public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
