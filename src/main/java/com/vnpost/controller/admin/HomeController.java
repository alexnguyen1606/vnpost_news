package com.vnpost.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "adminHomeController")

public class HomeController {
    @GetMapping("/admin")
    public String index() {
        return "admin/home";
    }
}
