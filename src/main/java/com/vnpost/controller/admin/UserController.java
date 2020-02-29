package com.vnpost.controller.admin;

import com.vnpost.dto.BaseDTO;
import com.vnpost.dto.UserDTO;
import com.vnpost.service.IRoleService;
import com.vnpost.service.impl.RoleService;
import com.vnpost.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller(value = "userAdmin")
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private IRoleService roleService;
    @GetMapping("/changeinfo")
    public String changeInfo(Model model){
        model.addAttribute("viewmodel",new UserDTO());
        return "web/user/changeInfo";
    }
    @PostMapping("/changePassword")
    public RedirectView changePassword(@ModelAttribute("viewmodel") UserDTO userDTO){
        userService.changePassWord(userDTO);
        return new RedirectView("/admin");
    }
    @GetMapping
    public ModelAndView index(
       @RequestParam(name = "page",required = false,defaultValue = "1") Integer page
            ,@RequestParam(name = "size",required = false,defaultValue = "7") Integer size
    ){
        BaseDTO baseModel = new BaseDTO();
        Integer totalUser = userService.findAll().size();
        baseModel.setPage(page);
        baseModel.setSize(size);
        baseModel.setTotalPages((int)Math.ceil((double)totalUser/size));
        Pageable pageable = PageRequest.of(page-1,size);
        ModelAndView mav = new ModelAndView("admin/user/list");
        mav.addObject("users",userService.findAll(pageable));
        mav.addObject("model",baseModel);
        return mav;
    }
    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView mav = new ModelAndView("admin/user/create");
        mav.addObject("viewmodel",new UserDTO());
        mav.addObject("roles",roleService.findAll());
        return mav;
    }
    @GetMapping(value = {"/edit/{id}"})
    public ModelAndView edit(@PathVariable(value = "id") Long userId){
        ModelAndView mav = new ModelAndView("admin/user/edit");
        UserDTO viewmodel = userService.findById(userId);
        viewmodel.getRoles().stream().map(item-> viewmodel.getListRole().add(item.getCode())).collect(Collectors.toList());
            mav.addObject("viewmodel",viewmodel);
            mav.addObject("roles",roleService.findAll());
        return mav;
    }
    @PostMapping("/edit")
    public String createOrUpdate(@ModelAttribute("viewmodel") @Valid UserDTO userDTO, BindingResult bindingResult){
        Long id = userDTO.getId();
        if (id==null){
            if (bindingResult.hasErrors()){
                return "admin/user/edit";
            }
            userService.save(userDTO);
        }else {
            if(bindingResult.hasErrors()){
                return "admin/user/edit";
            }
            userService.update(userDTO);
        }
        return "redirect:/admin/user";
    }
    @GetMapping(value = {"/delete/{id}"})
    public RedirectView delete(@PathVariable("id") Long id){
        userService.deleteOne(id);
        return new RedirectView("/admin/user");
    }
}
