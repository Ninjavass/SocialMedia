package org.example.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User1 user1;
    @ManyToOne
    @JoinColumn(name = "followerId")
    private User1 follower;

    public Follower() {
    }

    public Follower(User1 user1, User1 follower) {
        this.user1 = user1;
        this.follower = follower;
    }

    public Follower(Long id, User1 user1, User1 follower) {
        this.id = id;
        this.user1 = user1;
        this.follower = follower;
    }
}
