package com.vnpost.controller.admin;

import com.vnpost.dto.UserDTO;
import com.vnpost.service.IRoleService;
import com.vnpost.service.impl.RoleService;
import com.vnpost.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller(value = "userAdmin")
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private IRoleService roleService;
    @GetMapping("/changeinfo")
    public String changeInfo(Model model){
        model.addAttribute("viewmodel",new UserDTO());
        return "web/user/changeInfo";
    }
    @PostMapping("/changePassword")
    public RedirectView changePassword(@ModelAttribute("viewmodel") UserDTO userDTO){
        userService.changePassWord(userDTO);
        return new RedirectView("/admin");
    }
    @GetMapping
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("admin/user/list");
        mav.addObject("users",userService.findAll());
        mav.addObject("user",new UserDTO());
        return mav;
    }
    @GetMapping("/new")
    public ModelAndView create(){
        ModelAndView mav = new ModelAndView("admin/user/edit");
        mav.addObject("user",new UserDTO());
        mav.addObject("listRole",roleService.findAll());
        return mav;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(value = "id") Long userId){
        ModelAndView mav = new ModelAndView("admin/user/edit");
            mav.addObject("user",userService.findById(userId));
            mav.addObject("listRole",roleService.findAll());
        return mav;
    }
}
