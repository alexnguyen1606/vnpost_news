package com.vnpost.controller.web;

import com.vnpost.dto.BaseDTO;
import com.vnpost.service.IDeliveryService;
import com.vnpost.service.IPostageDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "webPostageDelivery")
public class PostageDeliveryController {
    @Autowired
    private IPostageDeliveryService postageDeliveryService;
    @Autowired
    private IDeliveryService deliveryService;

    @GetMapping("/dich-vu/buu-chinh-chuyen-phat")
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("web/service/postagedelivery/index");
        mav.addObject("postagedelivery", postageDeliveryService.findAll());
        return mav;
    }

    @GetMapping("/dich-vu/nhom/buu-chinh-chuyen-phat/{id}")
    public ModelAndView serviceList(@PathVariable("id") Long id
            , @RequestParam(name = "page", required = false, defaultValue = "6") Integer page
            , @RequestParam(name = "size", required = false, defaultValue = "1") Integer size
    ) {
        ModelAndView mav = new ModelAndView("web/service/postagedelivery/deliver-service");
        Integer totalItem = deliveryService.countByPostId(id);
        BaseDTO baseModel = new BaseDTO(page, size, (int) Math.ceil((double) totalItem / size));
        Pageable pageable = PageRequest.of(page - 1, size);
        mav.addObject("services", deliveryService.findByPostageDeliveryId(id, pageable));
        return mav;
    }

    @GetMapping("/dich-vu/buu-chinh-chuyen-phat/chi-tiet/{id}")
    public ModelAndView detail(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("web/service/postagedelivery/detail");
        mav.addObject("service", deliveryService.findById(id));
        return mav;
    }
}
