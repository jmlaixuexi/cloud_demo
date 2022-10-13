package com.jml.user.controller;

import com.jml.user.model.User;
import com.jml.user.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/{id}",method = {RequestMethod.GET})
    public User queryUserById(@PathVariable("id") long id){
        return userService.queryUserById(id);
    }
}
