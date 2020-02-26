package com.vnpost.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "adminPostageDeliveryController")
@RequestMapping("/admin/postage-delivery")
public class PostageDeliveryController {
    @GetMapping("/{id}")
    public ModelAndView index(@PathVariable("id") Long id){
        
        ModelAndView mav = new ModelAndView("admin/service/postagedeliver/index");
        return mav;
    }
}
