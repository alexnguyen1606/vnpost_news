package com.vnpost.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller(value = "webUserController")
public class UserController {
    @GetMapping("/changeinfo")
    public String changeInfo(){
        return "web/user/changeInfo";
    }
}
