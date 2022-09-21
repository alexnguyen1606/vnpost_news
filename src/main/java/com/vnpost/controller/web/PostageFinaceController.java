package com.vnpost.controller.web;

import com.vnpost.dto.BaseDTO;
import com.vnpost.service.IPostageFinaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "webPostFinaceController")
public class PostageFinaceController {
    @Autowired
    private IPostageFinaceService postageFinaceService;

    @GetMapping("/dich-vu/nhom/tai-chinh-buu-chinh")
    public ModelAndView indexService(
            @RequestParam(name = "page", required = false, defaultValue = "6") Integer page
            , @RequestParam(name = "size", required = false, defaultValue = "1") Integer size
    ) {
        ModelAndView mav = new ModelAndView("web/service/postfinace/index");
        Integer totalItem = postageFinaceService.count();
        BaseDTO baseModel = new BaseDTO(page, size, (int) Math.ceil((double) totalItem / size));
        Pageable pageable = PageRequest.of(page - 1, size);
        mav.addObject("postfinace", postageFinaceService.findAll(pageable));
        mav.addObject("model", baseModel);
        return mav;
    }

    @GetMapping("/dich-vu/tai-chinh-buu-chinh/chi-tiet/{id}")
    public ModelAndView detail(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("web/service/postfinace/detail");
        mav.addObject("service", postageFinaceService.findById(id));
        return mav;
    }

}
