package com.vnpost.controller.admin;

import com.vnpost.constant.SystemConstant;
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
import org.springframework.web.servlet.view.RedirectView;

@Controller(value = "adminNewsController")
@RequestMapping("/admin/news")
public class NewsController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private INewsService newsService;

    @GetMapping
    public ModelAndView listNews( //@RequestParam(name = "page",required = false,defaultValue = "1") Integer page
     //       ,@RequestParam(name = "size",required = false,defaultValue = "5") Integer size
    ){
        ModelAndView mav = new ModelAndView("admin/news/list");
//        BaseDTO baseModel = new BaseDTO();
//        Integer totalItem = newsService.findAllByStatus(SystemConstant.enable).size();
//        baseModel.setSize(size);
//        baseModel.setPage(page);
//        baseModel.setTotalPages((int) Math.ceil((double)totalItem/size));
//        Pageable pageable = PageRequest.of(page-1,size);
        mav.addObject("news",newsService.findAllByStatus(SystemConstant.enable));
     //   mav.addObject("model",baseModel);
        return mav;
    }
    @GetMapping("/disable")
    public ModelAndView listNewsDisable( //@RequestParam(name = "page",required = false,defaultValue = "1") Integer page
            //,@RequestParam(name = "size",required = false,defaultValue = "8") Integer size
    ){
        ModelAndView mav = new ModelAndView("admin/news/list");
//        BaseDTO baseModel = new BaseDTO();
//        Integer totalItem = newsService.findAllByStatus(SystemConstant.disable).size();
//        baseModel.setSize(size);
//        baseModel.setPage(page);
//        baseModel.setTotalPages(totalItem/size);
//        Pageable pageable = PageRequest.of(page-1,size);
        mav.addObject("news",newsService.findAllByStatus(SystemConstant.disable));
        //mav.addObject("model",baseModel);
        return mav;
    }
    @GetMapping("/edit/{id}")
    public String editNews(@PathVariable(value = "id",required = false) Long idNews,Model model
    ){

        NewsDTO viewModel = newsService.findById(idNews);
        viewModel.setParagraph1(viewModel.getListParagraph().get(0));
        viewModel.setParagraph2(viewModel.getListParagraph().get(1));
        viewModel.setParagraph3(viewModel.getListParagraph().get(2));
        model.addAttribute("viewmodel",viewModel);
        model.addAttribute("category",categoryService.findAll());
        return "admin/news/edit";
    }
    @PostMapping("/edit")
    public String update(@ModelAttribute("viewmodel") NewsDTO viewModel){
        System.out.println("check point update");
        //RedirectView rv = new RedirectView("/admin/news");
        viewModel.getListParagraph().add(viewModel.getParagraph1());
        viewModel.getListParagraph().add(viewModel.getParagraph2());
        viewModel.getListParagraph().add(viewModel.getParagraph3());
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
