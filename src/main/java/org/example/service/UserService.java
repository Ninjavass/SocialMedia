package org.example.service;

import org.example.model.User1;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User1 getUser(String username) {
        return userRepository.getByUsername(username);
    }

    public void addUser(User1 user) {
        userRepository.save(user);
    }

    public List<User1> getAllOtherUsers(String name) {
        return userRepository.getAllOtherUsers(name);
    }
}
