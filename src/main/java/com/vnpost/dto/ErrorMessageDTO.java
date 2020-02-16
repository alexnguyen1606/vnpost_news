package com.vnpost.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessageDTO {
    private String title;
    private String detail;

    public ErrorMessageDTO(int i, String localizedMessage) {
    }

    public ErrorMessageDTO(String title, String detail) {
        this.title = title;
        this.detail = detail;
    }


}
