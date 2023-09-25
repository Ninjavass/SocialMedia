package org.example.repository;

import org.example.model.User1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User1, Long> {

    @Query(value = "SELECT * FROM user1 u Where u.username = ?1", nativeQuery = true)
    User1 getByUsername(String username);

    @Query(value = "SELECT * FROM user1 u Where u.username <> ?1", nativeQuery = true)
    List<User1> getAllOtherUsers(String username);
}
