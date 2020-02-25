package com.vnpost.api.web;

import com.vnpost.dto.SubcribDTO;
import com.vnpost.service.ISubcribService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "apiWebSubcrib")
public class SubcribApi {
    @Autowired
    private ISubcribService subcribService;
    @PostMapping("/api/dang-ky")
    public SubcribDTO save(@RequestBody SubcribDTO subcribDTO){
        return subcribService.save(subcribDTO);
    }
}
