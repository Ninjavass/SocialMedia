package org.example.DatabaseConfiguration;

import org.example.model.Comment;
import org.example.model.Follower;
import org.example.model.Post;
import org.example.model.User1;
import org.example.repository.CommentRepository;
import org.example.repository.FollowerRepository;
import org.example.repository.PostRepository;
import org.example.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class DatabaseConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository,
                                        PostRepository postRepository,
                                        CommentRepository commentRepository,
                                        FollowerRepository followerRepository) {
        return args -> {
            User1 user1 = new User1(
                    "Spyros Savvopoulos",
                    "1",
                    true
            );
            User1 user2 = new User1(
                    "Takis Panou",
                    "2",
                    true
            );
            User1 user3 = new User1(
                    "Elena Mikou",
                    "3",
                    false
            );
            Post post1 = new Post(
                    "This is a post",
                    user1,
                    LocalDateTime.of(2021, 5, 10, 5, 20)
            );
            Post post2 = new Post(
                    "This is the second post",
                    user2,
                    LocalDateTime.of(2021, 9, 23, 14, 30)
            );
            Post post3 = new Post(
                    "This is the third post",
                    user3,
                    LocalDateTime.of(2022, 5, 15, 1, 20)
            );
            Post post4 = new Post(
                    "This is the fourth post",
                    user2,
                    LocalDateTime.of(2021, 4, 20, 2, 20)
            );
            Post post5 = new Post(
                    "This is the fifth post",
                    user3,
                    LocalDateTime.of(2022, 5, 15, 5, 40)
            );
            Post post6 = new Post(
                    "This is the sixth post",
                    user1,
                    LocalDateTime.of(2022, 4, 14, 2, 10)
            );
            Post post7 = new Post(
                    "This is the seventh post",
                    user1,
                    LocalDateTime.of(2023, 1, 19, 4, 50)
            );
            Comment comment1 = new Comment(
                    "This is a comment 1 for: This is a post",
                    post1,
                    user1,
                    LocalDateTime.of(2022, 1, 11, 6, 20)
            );
            Comment comment2 = new Comment(
                    "This is a comment 2 for: This is a post",
                    post1,
                    user1,
                    LocalDateTime.of(2022, 2, 12, 8, 20)
            );
            Comment comment3 = new Comment(
                    "This is a comment 3 for: This is a post",
                    post1,
                    user1,
                    LocalDateTime.of(2022, 3, 13, 9, 20)
            );
            Comment comment4 = new Comment(
                    "This is a comment 4 for: This is a post",
                    post1,
                    user2,
                    LocalDateTime.of(2022, 4, 14, 10, 20)
            );
            Comment comment5 = new Comment(
                    "This is a comment 5 for: This is a post",
                    post1,
                    user2,
                    LocalDateTime.of(2022, 5, 15, 1, 20)
            );
            Comment comment6 = new Comment(
                    "This is a comment 6 for: This is a post",
                    post1,
                    user1,
                    LocalDateTime.of(2022, 1, 11, 14, 30)
            );
            Comment comment7 = new Comment(
                    "This is a comment 7 for: This is a post",
                    post1,
                    user1,
                    LocalDateTime.of(2022, 1, 11, 14, 20)
            );
            Comment comment8 = new Comment(
                    "This is a comment 8 for: This is a post",
                    post1,
                    user1,
                    LocalDateTime.of(2022, 12, 20, 20, 45)
            );
            Comment comment9 = new Comment(
                    "This is a comment 9 for: This is a post",
                    post1,
                    user3,
                    LocalDateTime.of(2022, 4, 5, 2, 20)
            );
            Comment comment10 = new Comment(
                    "This is a comment 10 for: This is a post",
                    post1,
                    user3,
                    LocalDateTime.of(2022, 2, 2, 2, 40)
            );
            Follower follower1 = new Follower(
                    user2,
                    user1
            );
            Follower follower2 = new Follower(
                    user3,
                    user1
            );
            Follower follower3 = new Follower(
                    user1,
                    user2
            );
            Follower follower4 = new Follower(
                    user1,
                    user3
            );
            Comment comment11 = new Comment(
                    "This is a comment 11 for: This is the sixth post",
                    post6,
                    user2,
                    LocalDateTime.of(2022, 4, 10, 5, 40)
            );
            Comment comment12 = new Comment(
                    "This is a comment 12 for: This is the seventh post",
                    post7,
                    user3,
                    LocalDateTime.of(2023, 1, 15, 1, 40)
            );
            Comment comment13 = new Comment(
                    "This is a comment 13 for: This is the sixth post",
                    post6,
                    user1,
                    LocalDateTime.of(2022, 2, 22, 1, 40)
            );
            Comment comment14 = new Comment(
                    "This is a comment 14 for: This is the seventh post",
                    post7,
                    user2,
                    LocalDateTime.of(2023, 1, 15, 5, 40)
            );

            userRepository.saveAll(List.of(user1, user2, user3));
            postRepository.saveAll(List.of(post1, post2, post3, post4, post5, post6, post7));
            commentRepository.saveAll(List.of(comment1, comment2, comment3, comment4, comment5, comment6, comment7, comment8, comment9, comment10, comment11, comment12, comment13, comment14));
            followerRepository.saveAll(List.of(follower1, follower2, follower3, follower4));
        };
    }
}
