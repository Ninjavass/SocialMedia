package org.example.controller;

import org.example.model.Post;
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
public class CreatePostController {

    @Autowired
    PostsService postsService;

    @Autowired
    UserService userService;

    @GetMapping("createPost")
    public String createPostsPage(HttpSession session) {
        if (session.getAttribute("name") == null) return "redirect:/socialmedia/user/login";
        return "create_post";
    }

    @PostMapping("createPost")
    public String createPostsPostPage(@RequestParam("action") String action,
                                      @RequestParam("post") String inputPost,
                                      HttpSession session,
                                      ModelMap model) {
        if (session.getAttribute("name") == null) return "redirect:/socialmedia/user/login";
        if (action.equals("return")) return "redirect:/socialmedia/welcome";
        if (inputPost.isEmpty()) {
            model.put("Msg", "Please insert a text for the post");
            return "create_post";
        }
        Post post = new Post(inputPost, userService.getUser((String) session.getAttribute("name")), LocalDateTime.now());
        postsService.addNewPost(post);
        model.put("Msg", "Post created");
        return "create_post";
    }
}
