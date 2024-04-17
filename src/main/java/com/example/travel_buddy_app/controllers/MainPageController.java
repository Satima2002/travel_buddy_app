package com.example.travel_buddy_app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/auth")
@RequestMapping("/")
//@Controller
public class MainPageController {
//@GetMapping
@GetMapping ({"/index"})
    public String showHome(){
//        model.addAttribute("something", "this is coming from controller");
        return "index";
    }


}
