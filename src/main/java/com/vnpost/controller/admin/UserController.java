package com.vnpost.controller.admin;

import com.vnpost.dto.UserDTO;
import com.vnpost.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("admin/user/list");
        mav.addObject("users",userService.findAll());
        return mav;
    }
    @GetMapping("/new")
    public ModelAndView create(){
        ModelAndView mav = new ModelAndView("admin/user/edit");
        mav.addObject("user",new UserDTO());
        return mav;
    }
    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam(value = "id") Long userId){
        ModelAndView mav = new ModelAndView("admin/user/edit");
        if (userId==null){
            mav.addObject("user",new UserDTO());
        }else
            mav.addObject("user",userService.findById(userId));
        return mav;
    }
}
