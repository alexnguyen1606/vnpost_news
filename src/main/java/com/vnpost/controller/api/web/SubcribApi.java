package com.vnpost.controller.api.web;

import com.vnpost.dto.SubcribDTO;
import com.vnpost.service.ISubcribService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "apiWebSubcrib")
public class SubcribApi {
    @Autowired
    private ISubcribService subcribService;

    @PostMapping("/api/dang-ky")
    public void save(@RequestBody SubcribDTO subcribDTO){
        subcribService.save(subcribDTO);
    }
}
