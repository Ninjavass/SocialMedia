package org.example.service;

import org.example.model.Comment;
import org.example.repository.CommentRepository;
import org.example.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Boolean addNewComment(Comment comment) {
        Integer b = postRepository.getTotalCommentsByPost(comment.getPost().getPostId());
        if (postRepository.getTotalCommentsByPost(comment.getPost().getPostId()) == 10) return false;
        commentRepository.save(comment);
        return true;
    }

    public List<Comment> getView2(Long userId) {
        return commentRepository.getView2(userId);
    }
}
