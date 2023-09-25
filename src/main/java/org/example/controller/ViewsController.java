package org.example.controller;

import org.example.service.CommentService;
import org.example.service.FollowerService;
import org.example.service.PostsService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("socialmedia/views")
public class ViewsController {

    @Autowired
    CommentService commentService;

    @Autowired
    PostsService postsService;

    @Autowired
    UserService userService;

    @Autowired
    FollowerService followerService;

    @GetMapping("view1")
    public String view1Page(HttpSession session,
                            ModelMap model) {
        if (session.getAttribute("name") == null) return "redirect:/socialmedia/user/login";
        model.addAttribute("posts", postsService.getView1(userService.getUser((String) session.getAttribute("name")).getUserId()));
        return "view1";
    }

    @GetMapping("view2")
    public String view2Page(HttpSession session,
                            ModelMap model) {
        if (session.getAttribute("name") == null) return "redirect:/socialmedia/user/login";
        model.addAttribute("comments", commentService.getView2(userService.getUser((String) session.getAttribute("name")).getUserId()));
        return "view2";
    }

    @GetMapping("view4")
    public String view4Page(HttpSession session,
                            ModelMap model) {
        if (session.getAttribute("name") == null) return "redirect:/socialmedia/user/login";
        model.addAttribute("followers", followerService.getFollowers(userService.getUser((String) session.getAttribute("name")).getUserId()));
        return "view_followers";
    }

    @PostMapping("view1")
    public String view1PostPage(HttpSession session) {
        if (session.getAttribute("name") == null) return "redirect:/socialmedia/user/login";
        return "redirect:/socialmedia/welcome";
    }

    @PostMapping("view2")
    public String view2PostPage(HttpSession session) {
        if (session.getAttribute("name") == null) return "redirect:/socialmedia/user/login";
        return "redirect:/socialmedia/welcome";
    }

    @PostMapping("view4")
    public String view4PostPage(HttpSession session) {
        if (session.getAttribute("name") == null) return "redirect:/socialmedia/user/login";
        return "redirect:/socialmedia/welcome";
    }
}
