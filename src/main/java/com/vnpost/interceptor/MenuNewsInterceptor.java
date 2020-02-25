package com.vnpost.interceptor;

import com.vnpost.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MenuNewsInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private ICategoryService categoryService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       //request.setAttribute("category",categoryService.findAll());
        return true;
    }
}
