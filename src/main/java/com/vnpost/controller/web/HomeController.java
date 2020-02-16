package com.vnpost.controller.web;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(){
        return "web/home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

//    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
//        }
//        return new ModelAndView("redirect:/login");
//    }
//
//    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
//    public ModelAndView accessDenied() {
//        return new ModelAndView("redirect:/login?accessDenied");
//    }
}
