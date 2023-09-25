package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String password;
    private String email;
    private Boolean isPremium;
    @OneToMany(mappedBy = "user1", cascade = CascadeType.ALL)
    private List<Post> posts;
    @OneToMany(mappedBy = "user1", cascade = CascadeType.ALL)
    private List<Comment> comments;
    @OneToMany(mappedBy = "user1", cascade = CascadeType.ALL)
    private List<Follower> followers;
    @OneToMany(mappedBy = "user1", cascade = CascadeType.ALL)
    private List<Follower> following;

    public User1() {
    }

    public User1(String username, String password, Boolean isPremium) {
        this.username = username;
        this.password = password;
        try {
            this.email = username.split(" ")[0] + "_" + username.split(" ")[1] + "@email.com";
        }catch (Exception e) {
            this.email = username.split(" ")[0] + "@email.com";
        }
        this.isPremium = isPremium;
    }

    public User1(Long userId, String username, String password, Boolean isPremium, List<Post> posts, List<Comment> comments, List<Follower> followers, List<Follower> following) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = username + "@email.com";
        this.isPremium = isPremium;
        this.posts = posts;
        this.comments = comments;
        this.followers = followers;
        this.following = following;
    }
}
