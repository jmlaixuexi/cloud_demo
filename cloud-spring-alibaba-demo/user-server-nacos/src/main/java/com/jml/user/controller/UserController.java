package com.jml.user.controller;

import com.jml.user.model.User;
import com.jml.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/{id}",method = {RequestMethod.GET})
    public User queryUserById(@PathVariable("id") long id,@RequestHeader(value = "Token",required = false) String token){
        logger.info("Toke："+ token);
        return userService.queryUserById(id);
    }
}
