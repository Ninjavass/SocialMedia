package org.example.service;

import org.example.model.Follower;
import org.example.model.User1;
import org.example.repository.FollowerRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowerService {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FollowerRepository followerRepository;

    public Boolean AddFolollower(String followerName, Long followingId) {
        try {
            followerRepository.save(new Follower(userRepository.getById(followingId), userRepository.getByUsername(followerName)));
            return  true;
        }catch (Exception e) {return false;}

    }

    public boolean removeFolollowing(String followerName, Long followingId) {
        try {
            User1 followingUser = userRepository.getById(followingId);
            User1 followerUser = userRepository.getByUsername(followerName);
            followerRepository.deleteById(new Follower(followerRepository.getByFollower(followerUser.getUserId(), followingUser.getUserId()) , followingUser, followerUser).getId());
            return  true;
        }catch (Exception e) {return false;}
    }

    public List<Follower> getFollowers(Long userId) {
        return followerRepository.getFollowers(userId);
    }

    public List<Follower> getAllFollowingUsers(String username) {
        return followerRepository.getAllFollowing(userService.getUser(username).getUserId());
    }
}
