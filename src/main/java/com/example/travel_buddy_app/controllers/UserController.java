package com.example.travel_buddy_app.controllers;


import com.example.travel_buddy_app.dto.UserDto;
import com.example.travel_buddy_app.entities.User;
import com.example.travel_buddy_app.services.CustomUserDetailsServices;
import com.example.travel_buddy_app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
//@CrossOrigin
public class UserController {

    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public String index(){

        return "index";
    }
    @GetMapping("/About")
    public String about(){

        return "About";
    }

    @GetMapping("/home")
    public String home(Model model, Principal principal){
        UserDetails userDetails=userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("userDetail",userDetails);
        return "home";
    }

    @GetMapping("/signin")
    public String signin(Model model, UserDto userDto){
        model.addAttribute("user", userDto);
        return "signin";
    }


    @GetMapping("/signup")
    public String showForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

    @PostMapping("/signup")
    public String signupSave(@ModelAttribute("user") UserDto userDto, Model model){
        User user=userService.findByUsername(userDto.getEmail());
        //if (user!= null){
         //   model.addAttribute("userexist",user);
           // return "signin";
        //}
        userService.save(userDto);
        return "redirect:/signup?success";
    }

}


