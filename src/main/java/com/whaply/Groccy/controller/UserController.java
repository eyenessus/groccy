package com.whaply.Groccy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whaply.Groccy.infrastructure.entities.User;
import com.whaply.Groccy.interfaces.IUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }
}
