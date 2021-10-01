package com.ss.firstspring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class SecurityController {

    // 4 different controllers for different auth.
    @RequestMapping(path="/public")
    public String publicAPI(){
        return "Hello from Public";
    }

    @RequestMapping(path="/protected")
    public String protectedAPI(){
        return "Hello from Protected";
    }

    @RequestMapping(path="/user")
    public String userAPI(){
        return "Hello from User";
    }

    @RequestMapping(path="/admin")
    public String adminAPI(){
        return "Hello from Admin";
    }
}
