package com.vnpost.sort;

import com.vnpost.dto.UserDTO;

import java.util.Comparator;

public class NewsSort implements Comparator<UserDTO> {
    @Override
    public int compare(UserDTO o1, UserDTO o2) {
        return o1.getCreatedDate().compareTo(o2.getCreatedDate());
    }



}
