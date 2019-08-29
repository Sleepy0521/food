package com.sleepy.food.controller;


import com.sleepy.food.bean.Msg;
import com.sleepy.food.entity.User;
import com.sleepy.food.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sleepy
 * @since 2019-08-29
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getUserList")
    public Msg getUserList(){
        List<User> users = userService.list();
        return Msg.success().add("users",users);
    }

    @PostMapping("/register")
    public Msg register(@RequestBody User user){
        boolean save = userService.save(user);
        return Msg.success().add("waring",save);
    }
}

