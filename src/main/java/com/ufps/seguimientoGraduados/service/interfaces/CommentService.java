package com.ufps.seguimientoGraduados.service.interfaces;

import com.ufps.seguimientoGraduados.persistence.entity.Comment;

import java.util.Optional;

public interface CommentService {
    Optional<Comment> getCommentById(Long id);
    void createComment(Long postId, Comment comment, Long userId);
    void updateComment(Long id, Comment comment);
    void deleteComment(Long id);
}
