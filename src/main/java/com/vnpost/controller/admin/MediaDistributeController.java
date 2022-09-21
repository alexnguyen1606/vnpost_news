package com.vnpost.controller.admin;

import com.vnpost.dto.BaseDTO;
import com.vnpost.dto.MediaDistributionDTO;
import com.vnpost.dto.PostageFinaceDTO;
import com.vnpost.service.IMediaDistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller(value = "adminMediaDistributeController")
public class MediaDistributeController {
    @Autowired
    private IMediaDistributionService mediaDistributionService;

    @GetMapping("/admin/media-distribute")
    public ModelAndView list(
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page
            , @RequestParam(name = "size", required = false, defaultValue = "7") Integer size
    ) {
        ModelAndView mav = new ModelAndView("admin/service/mediadistribute/list");
        Integer totalItems = mediaDistributionService.count();
        BaseDTO baseModel = new BaseDTO(page, size, (int) Math.ceil((double) totalItems / size));
        Pageable pageable = PageRequest.of(page - 1, size);
        mav.addObject("service", mediaDistributionService.findAll(pageable));
        mav.addObject("model", baseModel);
        return mav;
    }

    @GetMapping("/admin/media-distribute/create")
    public ModelAndView edit() {
        ModelAndView mav = new ModelAndView("admin/service/mediadistribute/edit");
        mav.addObject("service", new MediaDistributionDTO());
        return mav;
    }

    @GetMapping("/admin/media-distribute/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        ModelAndView mav = new ModelAndView("admin/service/mediadistribute/edit");
        mav.addObject("service", mediaDistributionService.findById(id));
        return mav;
    }

    @PostMapping("/admin/media-distribute/edit")
    public RedirectView edit(@ModelAttribute("service") MediaDistributionDTO mediaDistributionDTO) {
        if (mediaDistributionDTO.getId() == null) {
            mediaDistributionService.save(mediaDistributionDTO);
        } else {
            mediaDistributionService.update(mediaDistributionDTO);
        }
        return new RedirectView("/admin/media-distribute");
    }
}
