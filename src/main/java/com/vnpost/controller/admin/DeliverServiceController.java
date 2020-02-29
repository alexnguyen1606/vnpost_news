package com.vnpost.controller.admin;

import com.vnpost.annotations.Password;
import com.vnpost.dto.BaseDTO;
import com.vnpost.dto.DeliveryServiceDTO;
import com.vnpost.service.IDeliveryService;
import com.vnpost.service.IPostageDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller(value = "adminDeliverServiceController")
@RequestMapping("/admin/postage-delivery/service")
public class DeliverServiceController {
    @Autowired
    private IDeliveryService deliveryService;
    @Autowired
    private IPostageDeliveryService postageDeliveryService;
    @GetMapping("")
    public ModelAndView index(
       @RequestParam(value = "page",required = false,defaultValue = "1") Integer page
       ,@RequestParam(value = "size",required = false,defaultValue = "7") Integer size
    ){
        ModelAndView mav = new ModelAndView("admin/service/postagedelivery/deliver-service");
        Integer totalItem = Math.toIntExact(deliveryService.count());
        BaseDTO baseModel = new BaseDTO();
        baseModel.setPage(page);
        baseModel.setSize(size);
        baseModel.setTotalPages((int)Math.ceil((double)totalItem/size));
        mav.addObject("model",baseModel);
        Pageable pageable = PageRequest.of(page-1,size);
        mav.addObject("services",deliveryService.findAll(pageable));
        return mav;
    }
    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView mav = new ModelAndView("admin/service/postagedelivery/edit-service");
        mav.addObject("service",new DeliveryServiceDTO());
        mav.addObject("type",postageDeliveryService.findAll());
        return mav;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id){
        ModelAndView mav = new ModelAndView("admin/service/postagedelivery/edit-service");
        mav.addObject("type",postageDeliveryService.findAll());
        mav.addObject("service",deliveryService.findById(id));
        return mav;
    }
    @PostMapping("/edit")
    public RedirectView createOrUpdate(@ModelAttribute("service") DeliveryServiceDTO deliveryServiceDTO){
        if (deliveryServiceDTO.getId()==null){
            deliveryService.save(deliveryServiceDTO);
        }else {
            deliveryService.update(deliveryServiceDTO);
        }

        return new RedirectView("/admin/postage-delivery/service");
    }
}
