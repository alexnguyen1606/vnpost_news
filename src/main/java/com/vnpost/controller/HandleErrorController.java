package com.vnpost.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class HandleErrorController implements ErrorController {
    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        ModelAndView mav = new ModelAndView("error");
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            mav.addObject("STATUS_CODE", statusCode);
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                mav.addObject("ERROR", "Page Not Found");
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                mav.addObject("ERROR", "Internal Server Error");
            }
            return mav;
        }
        mav.addObject("ERROR","Unknow ERROR CODE");
        return mav;
    }
    @Override
    public String getErrorPath () {
        return "/error";
    }
}
