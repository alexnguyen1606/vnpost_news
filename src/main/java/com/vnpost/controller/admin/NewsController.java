package com.vnpost.controller.admin;

import com.vnpost.utils.constant.SystemConstant;
import com.vnpost.dto.BaseDTO;
import com.vnpost.dto.NewsDTO;
import com.vnpost.service.ICategoryService;
import com.vnpost.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "adminNewsController")
@RequestMapping("/admin/news")
public class NewsController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private INewsService newsService;

    @GetMapping
    public ModelAndView listNews(
           @ModelAttribute("newsSearch") NewsDTO newsDTO
            ,@RequestParam(name = "page",required = false,defaultValue = "1") Integer page
            ,@RequestParam(name = "size",required = false,defaultValue = "5") Integer size
    ){
        ModelAndView mav = new ModelAndView("admin/news/list");
        BaseDTO baseModel = new BaseDTO();
        Integer totalItem = newsService.findAll().size();
        baseModel.setSize(size);
        baseModel.setPage(page);
        baseModel.setTotalPages((int) Math.ceil((double)totalItem/size));
        Pageable pageable = PageRequest.of(page-1,size);
        mav.addObject("news",newsService.searchByAdmin(newsDTO,pageable));
        mav.addObject("categories",categoryService.findAll());
        mav.addObject("model",baseModel);
        mav.addObject("newsSearch",newsDTO);
        return mav;
    }
    @GetMapping("/disable")
    public ModelAndView listNewsDisable(
            @ModelAttribute("newsSearch") NewsDTO newsDTO
            ,@RequestParam(name = "page",required = false,defaultValue = "1") Integer page
            ,@RequestParam(name = "size",required = false,defaultValue = "8") Integer size
    ){
        newsDTO.setStatus(SystemConstant.disable);
        ModelAndView mav = new ModelAndView("admin/news/list");
        BaseDTO baseModel = new BaseDTO();
        Integer totalItem = newsService.findAllByStatus(SystemConstant.disable).size();
        baseModel.setSize(size);
        baseModel.setPage(page);
        baseModel.setTotalPages((int) Math.ceil((double)totalItem/size));
        Pageable pageable = PageRequest.of(page-1,size);
        mav.addObject("news",newsService.searchByAdmin(newsDTO,pageable));
        mav.addObject("categories",categoryService.findAll());
        mav.addObject("model",baseModel);
        mav.addObject("newsSearch",newsDTO);
        return mav;
    }
    @GetMapping("/edit/{id}")
    public String editNews(@PathVariable(value = "id",required = false) Long idNews,Model model
    ){

        NewsDTO viewModel = newsService.findById(idNews);
        model.addAttribute("viewmodel",viewModel);
        model.addAttribute("category",categoryService.findAll());
        return "admin/news/edit";
    }
    @PostMapping("/edit")
    public String update(@ModelAttribute("viewmodel") NewsDTO viewModel){
        System.out.println("check point update");
        //RedirectView rv = new RedirectView("/admin/news");
        if (viewModel.getId()==null){
            newsService.save(viewModel);
        }else {
            newsService.update(viewModel);
        }

//        rv.addStaticAttribute("news",newsService.findAllByStatus(SystemConstant.enable));
        return "redirect:/admin/news";
    }
    @GetMapping("/create")
    public String createNews(Model model){
        model.addAttribute("viewmodel",new NewsDTO());
        model.addAttribute("category",categoryService.findAll());
        return "admin/news/edit";
    }


}
