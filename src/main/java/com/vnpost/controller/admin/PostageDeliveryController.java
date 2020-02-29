package com.vnpost.controller.admin;

import com.vnpost.dto.PostageDeliveryDTO;
import com.vnpost.service.IPostageDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller(value = "adminPostageDeliveryController")
@RequestMapping("/admin/postage-delivery")
public class PostageDeliveryController {
    @Autowired
    private IPostageDeliveryService postageDeliveryService;
    @GetMapping()
    public ModelAndView index(){
        
        ModelAndView mav = new ModelAndView("admin/service/postagedelivery/index");
        mav.addObject("postdeliveries",postageDeliveryService.findAll());
        return mav;
    }
    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView mav = new ModelAndView("admin/service/postagedelivery/edit-postagedeliver");
        mav.addObject("postdelivery",new PostageDeliveryDTO());
        return mav;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("admin/service/postagedelivery/edit-postagedeliver");
        mav.addObject("postdelivery",postageDeliveryService.findAll());
        return mav;
    }
    @PostMapping("/edit")
    public RedirectView edit(@ModelAttribute("postdelivery") PostageDeliveryDTO postageDeliveryDTO){

        if (postageDeliveryDTO.getId()==null){
            postageDeliveryService.save(postageDeliveryDTO);
        }else {
            postageDeliveryService.update(postageDeliveryDTO);
        }
        return new RedirectView("/admin/postage-delivery");
    }
}
