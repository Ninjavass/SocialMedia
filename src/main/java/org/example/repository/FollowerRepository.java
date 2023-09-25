package org.example.repository;

import org.example.model.Follower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FollowerRepository extends JpaRepository<Follower, Long> {
    @Query(value = "SELECT id FROM follower f INNER JOIN user1 u ON u.user_id = f.follower_id Where f.follower_id = ?1 AND f.user_id = ?2", nativeQuery = true)
    Long getByFollower(Long followerUser, Long followingUser);

    @Query(value = "SELECT * FROM follower f INNER JOIN user1 u ON u.user_id = f.user_id Where f.user_id = ?1", nativeQuery = true)
    List<Follower> getFollowers(Long userId);

    @Query(value = "SELECT * FROM follower f INNER JOIN user1 u ON u.user_id = f.user_id Where f.follower_id = ?1", nativeQuery = true)
    List<Follower> getAllFollowing(Long userId);
}
