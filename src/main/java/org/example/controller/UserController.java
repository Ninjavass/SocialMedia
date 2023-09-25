package org.example.controller;

import org.example.model.User1;
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
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("user/login")
    public String loginPage(ModelMap model) {
        model.clear();
        return "login";
    }

    @GetMapping("user/register")
    public String registerPage(ModelMap model) {
        return "register";
    }

    @PostMapping("user/login")
    public String loginPostPage(@RequestParam("action") String action,
                                @RequestParam String username,
                                @RequestParam String password,
                                HttpSession session,
                                ModelMap model) {
        if (action.equals("register")) return  "redirect:/socialmedia/user/register";
        User1 user = userService.getUser(username);
        if (user == null) {
            model.put("errorMsg", "User not found");
            return "login";
        }
        if (!user.getPassword().equals(password)) {
            model.put("errorMsg", "User's credentials incorrect");
            return "login";
        }
        session.setAttribute("name", username);
        return "redirect:/socialmedia/welcome";
    }

    @PostMapping("user/register")
    public String registerPostPage(@RequestParam("action")   String action,
                                   @RequestParam("username") String username,
                                   @RequestParam("password") String password,
                                   @RequestParam(value = "premium", required = false)  Boolean isPremium,
                                   HttpSession session) {
        if (action.equals("return")) return  "redirect:/socialmedia/user/login";
        User1 user = new User1(username, password, (isPremium != null && isPremium));
        userService.addUser(user);
        session.setAttribute("name", username);
        return "redirect:/socialmedia/welcome";
    }
}
