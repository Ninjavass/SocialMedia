package org.example.controller;

import org.example.model.Comment;
import org.example.service.CommentService;
import org.example.service.PostsService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@RequestMapping("socialmedia")
public class CreateCommentController {

    @Autowired
    PostsService postsService;

    @Autowired
    UserService userService;

    @Autowired
    CommentService commentService;

    @GetMapping("createComment")
    public String createCommentPage(HttpSession session,
                                    ModelMap model) {
        if (session.getAttribute("name") == null) return "redirect:/socialmedia/user/login";
        model.addAttribute("posts", postsService.getAllPosts());
        return "create_comment";
    }

    @PostMapping("createComment")
    public String createCommentPostPage(@RequestParam("action") String action,
                                        @RequestParam("comment") String inputComment,
                                        @RequestParam(value = "selectedPost", required = false) Long postId,
                                        HttpSession session,
                                        ModelMap model) {
        if (session.getAttribute("name") == null) return "redirect:/socialmedia/user/login";
        if (action.equals("return")) return "redirect:/socialmedia/welcome";
        if (inputComment.isEmpty()) {
            model.put("Msg", "Please insert a text for the comment");
            model.addAttribute("posts", postsService.getAllPosts());
            return "create_comment";
        }
        Comment comment = new Comment(inputComment, postsService.getById(postId), userService.getUser((String) session.getAttribute("name")), LocalDateTime.now());
        if (!commentService.addNewComment(comment)) {
            model.addAttribute("posts", postsService.getAllPosts());
            model.put("Msg", "You can't comment more than 10 comments to a post");
            return "create_comment";
        }
        model.addAttribute("posts", postsService.getAllPosts());
        model.put("Msg", "Comment created successfully");
        return "create_comment";
    }
}
