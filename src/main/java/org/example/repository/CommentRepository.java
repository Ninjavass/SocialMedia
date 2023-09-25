package org.example.repository;

import org.example.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT * FROM comment c INNER JOIN post p ON c.post_id = p.post_id INNER JOIN user1 u ON p.user_id = u.user_id Where p.user_id = ?1 ORDER BY p.created_at, c.created_at DESC LIMIT 100", nativeQuery = true)
    List<Comment> getView2(Long userId);
}
