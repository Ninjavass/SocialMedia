package org.example.controller;

import org.example.service.FollowerService;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("socialmedia")
public class FollowerController {

    @Autowired
    FollowerService followerService;

    @Autowired
    UserService userService;

    @GetMapping("followers/follow")
    public String followerPage(ModelMap model,
                               HttpSession session) {
        if (session.getAttribute("name") == null) return "redirect:/socialmedia/user/login";
        model.addAttribute("users", userService.getAllOtherUsers(((String) session.getAttribute("name"))));
        return "follow";
    }

    @GetMapping("followers/unfollow")
    public String unfollowerPage(ModelMap model,
                               HttpSession session) {
        if (session.getAttribute("name") == null) return "redirect:/socialmedia/user/login";
        model.addAttribute("following", followerService.getAllFollowingUsers(((String) session.getAttribute("name"))));
        return "unfollow";
    }

    @PostMapping("followers/follow")
    public String createFollowerPostPage(@RequestParam("action") String action,
                                        @RequestParam("selectedUser") Long followingId,
                                        HttpSession session,
                                        ModelMap model) {
        if (session.getAttribute("name") == null) return "redirect:/socialmedia/user/login";
        if (action.equals("return")) return "redirect:/socialmedia/welcome";
        if (!followerService.AddFolollower((String) session.getAttribute("name"), followingId)) {
            model.put("Msg", "Your follow has not been created");
            return "follow";
        }
        model.put("Msg", "Your follow has been created");
        model.addAttribute("users", userService.getAllOtherUsers(((String) session.getAttribute("name"))));
        return "follow";
    }

    @PostMapping("followers/unfollow")
    public String unFollowerPostPage(@RequestParam("action") String action,
                                     @RequestParam(value = "selectedUser", required = false) Long followingId,
                                     HttpSession session,
                                     ModelMap model) {
        if (session.getAttribute("name") == null) return "redirect:/socialmedia/user/login";
        if (action.equals("return")) return "redirect:/socialmedia/welcome";
        if (!followerService.removeFolollowing((String) session.getAttribute("name"), followingId)) {
            model.addAttribute("following", followerService.getAllFollowingUsers(((String) session.getAttribute("name"))));
            model.put("Msg", "Your unfollow has was unsuccessful");
            return "unfollow";
        }
        model.addAttribute("following", followerService.getAllFollowingUsers(((String) session.getAttribute("name"))));
        model.put("Msg", "Your unfollow was successful");
        return "unfollow";
    }
}
