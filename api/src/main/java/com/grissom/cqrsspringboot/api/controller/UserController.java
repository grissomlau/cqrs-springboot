package com.grissom.cqrsspringboot.api.controller;

import com.grissom.cqrsspringboot.query.dto.UserQueryDTO;
import com.grissom.cqrsspringboot.query.service.UserQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Grissom
 * @date 2/3/2021 11:55 AM
 **/
@RestController
@RequestMapping("user")
public class UserController {
    private final UserQueryService userQueryService;

    public UserController(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }

    @GetMapping("/name/{id}")
    public String getName(@PathVariable("id") Long id) {
        return this.userQueryService.getName(id);
    }

    @GetMapping("/{id}")
    public UserQueryDTO getUser(@PathVariable("id") Long id){
        return this.userQueryService.getUser(id);
    }
}
