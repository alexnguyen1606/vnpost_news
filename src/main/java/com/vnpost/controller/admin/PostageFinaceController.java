package com.vnpost.controller.admin;

import com.vnpost.dto.BaseDTO;
import com.vnpost.dto.PostageFinaceDTO;
import com.vnpost.service.IPostageFinaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller(value = "adminPostageFinaceController")
public class PostageFinaceController {
    @Autowired
    private IPostageFinaceService postageFinaceService;

    @GetMapping("/admin/postage-finace")
    public ModelAndView list(
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page
            , @RequestParam(name = "size", required = false, defaultValue = "7") Integer size
    ) {
        ModelAndView mav = new ModelAndView("admin/service/postfinace/list");
        Integer totalItem = postageFinaceService.count();
        Integer totalPages = (int) Math.ceil((double) (totalItem / size));
        BaseDTO baseModel = new BaseDTO(page, size, totalPages);
        Pageable pageable = PageRequest.of(page - 1, size);
        mav.addObject("model", baseModel);
        mav.addObject("services", postageFinaceService.findAll(pageable));
        return mav;
    }

    @GetMapping("/admin/postage-finace/create")
    public ModelAndView edit() {
        ModelAndView mav = new ModelAndView("admin/service/postfinace/edit");
        mav.addObject("service", new PostageFinaceDTO());
        return mav;
    }

    @GetMapping("/admin/postage-finace/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("admin/service/postfinace/edit");
        mav.addObject("service", postageFinaceService.findById(id));
        return mav;
    }

    @PostMapping("/admin/postage-finace/edit")
    public RedirectView createOrUpdate(@ModelAttribute("service") PostageFinaceDTO postageFinaceDTO) {
        if (postageFinaceDTO.getId() == null) {
            postageFinaceService.save(postageFinaceDTO);
        } else {
            postageFinaceService.update(postageFinaceDTO);
        }
        return new RedirectView("/admin/postage-finace");
    }

}
