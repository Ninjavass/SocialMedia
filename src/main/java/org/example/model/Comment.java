package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(length = 1000)
    private String comment;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User1 user1;

    public Comment() {
    }

    public Comment(String comment, Post post, User1 user1, LocalDateTime createdAt) {
        this.comment = comment;
        this.post = post;
        this.user1 = user1;
        this.createdAt = createdAt;
    }

    public Comment(Long commentId, String comment, Post post, User1 user1, LocalDateTime createdAt) {
        this.commentId = commentId;
        this.comment = comment;
        this.post = post;
        this.user1 = user1;
        this.createdAt = createdAt;
    }
}
