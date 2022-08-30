package com.example.springbootexample.controller;

import com.example.springbootexample.domain.User;
import com.example.springbootexample.repository.UserDao;
import com.example.springbootexample.service.UserService;
import com.example.springbootexample.utils.Result;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<User> loginController(@RequestParam String uname, @RequestParam String password) {
        User user = userService.loginService(uname, password);
        if (user != null) {
            return Result.success(user, "登录成功！");
        } else {
            return Result.error("123", "账号或密码错误！");
        }
    }

    @PostMapping("/register")
    public Result<User> registController(@RequestBody User newUser) {
        User user = userService.registService(newUser);
        if (user != null) {
            return Result.success(user, "注册成功！");
        } else {
            return Result.error("456", "用户名已存在！");
        }
    }

    @GetMapping("/find")
    public List<User> findController(@RequestParam(value = "uid", required = true) Long uid) {
        List<User> users = userService.findService(uid);
        System.out.print(users);
        return users;
    }

    @GetMapping("/findUserAll")
    public List<User> findAllController(Model model) {
        List<User> users = userService.findUserAll();
        System.out.print(users);
        return users;
    }
    
    @PostMapping("/deleteByUid")
    public String deleteByUidController(@RequestParam Long uid) {
        userService.deleteByUid(uid);
        return "删除成功";
    }
}
