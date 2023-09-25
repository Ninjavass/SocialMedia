package org.example.repository;

import org.example.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT COUNT(*) FROM post p INNER JOIN comment c ON p.post_id = c.post_id Where p.post_id = ?1", nativeQuery = true)
    Integer getTotalCommentsByPost(Long postId);

    @Query(value = "SELECT * FROM post p INNER JOIN user1 u ON p.user_id = u.user_id INNER JOIN follower f ON u.user_id = f.user_id Where f.follower_id = ?1 ORDER BY p.created_at DESC", nativeQuery = true)
    List<Post> getView1(Long userId);
}
