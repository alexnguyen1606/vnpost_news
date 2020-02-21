package com.vnpost.controller.admin;

import com.vnpost.constant.SystemConstant;
import com.vnpost.dto.NewsDTO;
import com.vnpost.dto.NewsViewModel;
import com.vnpost.service.ICategoryService;
import com.vnpost.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller(value = "adminNewsController")
@RequestMapping("/admin/news")
public class NewsController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private INewsService newsService;

    @GetMapping
    public ModelAndView listNews(){
        ModelAndView mav = new ModelAndView("admin/news/list");
        mav.addObject("news",newsService.findAllByStatus(SystemConstant.enable));
        return mav;
    }
    @GetMapping("/disable")
    public ModelAndView listNewsDisable(){
        ModelAndView mav = new ModelAndView("admin/news/list");
        mav.addObject("news",newsService.findAllByStatus(SystemConstant.disable));
        return mav;
    }
    @GetMapping("/edit/{id}")
    public String editNews(@PathVariable(value = "id",required = false) Long idNews,Model model){

        //NewsViewModel newsViewModel = new NewsViewModel();
        //newsViewModel.setNews(newsService.findById(idNews));
        model.addAttribute("viewmodel",newsService.findById(idNews));
        model.addAttribute("category",categoryService.findAll());
        return "admin/news/edit";
    }
    @PostMapping("/edit")
    public RedirectView update(@ModelAttribute("viewmodel") NewsDTO viewModel){
        System.out.println("check point update");
        RedirectView rv = new RedirectView("/admin/news");
        viewModel.getListParagraph().add(viewModel.getParagraph1());
        viewModel.getListParagraph().add(viewModel.getParagraph2());
        viewModel.getListParagraph().add(viewModel.getParagraph3());
        if (viewModel.getId()==null){
            newsService.save(viewModel);
        }else {
            newsService.update(viewModel);
        }

        rv.addStaticAttribute("news",newsService.findAllByStatus(SystemConstant.enable));
        return rv;
    }
    @GetMapping("/create")
    public String createNews(Model model){
        model.addAttribute("viewmodel",new NewsDTO());
        model.addAttribute("category",categoryService.findAll());
        return "admin/news/edit";
    }


}
