package com.whaply.Groccy.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whaply.Groccy.infrastructure.entities.User;
import com.whaply.Groccy.interfaces.IUserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping() 
    public Map<String, Integer> createUser(@RequestBody User user) {
        HashMap<String,Integer> response = new HashMap<>();
        response.put("id", userService.create(user));
        return response;
    }


}
