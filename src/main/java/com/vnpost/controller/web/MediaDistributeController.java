package com.vnpost.controller.web;

import com.vnpost.dto.BaseDTO;
import com.vnpost.service.IMediaDistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "webMediaDistibute")
public class MediaDistributeController {
    @Autowired
    private IMediaDistributionService mediaDistributionService;

    @GetMapping("/dich-vu/nhom/phan-phoi-truyen-thong")
    public ModelAndView indexService(
            @RequestParam(name = "page", required = false, defaultValue = "6") Integer page
            , @RequestParam(name = "size", required = false, defaultValue = "1") Integer size
    ) {
        ModelAndView mav = new ModelAndView("web/service/mediadistribute/index");
        Integer totalItem = mediaDistributionService.count();
        BaseDTO baseModel = new BaseDTO(page, size, (int) Math.ceil((double) totalItem / size));
        Pageable pageable = PageRequest.of(page - 1, size);
        mav.addObject("mediadistribute", mediaDistributionService.findAll(pageable));
        mav.addObject("model", baseModel);
        return mav;
    }

    @GetMapping("/dich-vu/phan-phoi-truyen-thong/chi-tiet/{id}")
    public ModelAndView detail(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("web/service/mediadistribute/detail");
        mav.addObject("service", mediaDistributionService.findById(id));
        return mav;
    }
}
