package com.ufps.seguimientoGraduados.persistence.repository;

import com.ufps.seguimientoGraduados.persistence.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByPost_PostId(Long postId);
}
