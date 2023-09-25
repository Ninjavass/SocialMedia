package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    @Column(length = 1000)
    private String post;
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User1 user1;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Post() {
    }

    public Post(String post, User1 user1, LocalDateTime createdAt) {
        this.post = post;
        this.user1 = user1;
        this.createdAt = createdAt;
    }

    public Post(Long postId, String post, User1 user1, List<Comment> comments, LocalDateTime createdAt) {
        this.postId = postId;
        this.post = post;
        this.user1 = user1;
        this.comments = comments;
        this.createdAt = createdAt;
    }
}
