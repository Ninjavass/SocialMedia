package org.example.service;

import org.example.model.Post;
import org.example.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostsService {

    @Autowired
    PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public void addNewPost(Post post) {
        postRepository.save(post);
    }

    public Post getById(Long postId) {
        return postRepository.getById(postId);
    }

    public List<Post> getView1(Long userId) {
        return postRepository.getView1(userId);
    }
}
