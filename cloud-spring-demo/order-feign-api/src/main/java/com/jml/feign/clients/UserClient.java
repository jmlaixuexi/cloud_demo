package com.jml.feign.clients;


import com.jml.feign.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-server")
public interface UserClient {

    @GetMapping("/user/{id}")
    User findUserById(@PathVariable("id") long id);

}

