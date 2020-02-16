package com.vnpost.service.impl;

import com.vnpost.enums.WapperMenuItem;
import com.vnpost.service.IMenuWapperService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class MenuWapperServer implements IMenuWapperService {
    @Override
    public Map<String, String> findAll() {
        Map<String,String> menu = new HashMap<>();
        for (WapperMenuItem item : WapperMenuItem.values()){
            menu.put(item.name(),item.getValue());
        }
        return menu;
    }
}
