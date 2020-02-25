package com.vnpost.config;

import com.vnpost.interceptor.MenuNewsInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      //  registry.addInterceptor(new OldLoginInterceptor()).addPathPatterns("/login");
      //  registry.addInterceptor(new MenuNewsInterceptor()).addPathPatterns("/tin-tuc*","/bai-viet");
    }
}
