package com.whaply.Groccy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whaply.Groccy.dtos.requests.UserRequest;
import com.whaply.Groccy.dtos.responses.UserResponse;
import com.whaply.Groccy.interfaces.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping() 
    public UserResponse createUser(@RequestBody UserRequest user) {
        return userService.create(user);
    }


}
