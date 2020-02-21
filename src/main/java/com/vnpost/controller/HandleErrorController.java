package com.vnpost.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HandleErrorController implements ErrorController  {
    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("web/home");
        return mav;
    }
    @Override
    public String getErrorPath () {
        return "/error";
    }
}
