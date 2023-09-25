package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("socialmedia")
public class WelcomeController {

    @GetMapping("welcome")
    public String welcomePage(HttpSession session,
                              ModelMap model) {
        if ((String) session.getAttribute("name") == null) return "redirect:/socialmedia/user/login";
        model.put("username", (String) session.getAttribute("name"));
        return "welcome";
    }

    @PostMapping("welcome")
    public String welcomePostPage(@RequestParam("action") String action,
                                  HttpSession session) {
        if (session.getAttribute("name") == null) return "redirect:/socialmedia/user/login";
        switch (action) {
            case "log_out":
                return "redirect:/socialmedia/user/login";
            case "post":
                return "redirect:/socialmedia/createPost";
            case "comment":
                return "redirect:/socialmedia/createComment";
            case "follow":
                return "redirect:/socialmedia/followers/follow";
            case "unFollow":
                return "redirect:/socialmedia/followers/unfollow";
            case "view1":
                return "redirect:/socialmedia/views/view1";
            case "view2":
                return "redirect:/socialmedia/views/view2";
            case "view4":
                return "redirect:/socialmedia/views/view4";
            default:
                return "redirect:/socialmedia/welcome";
        }
    }
}
