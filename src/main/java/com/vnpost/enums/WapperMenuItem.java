package com.vnpost.enums;

public enum WapperMenuItem {
    TIN_TUC("/tin-tuc"),
    TAI_CHINH_BUU_CHINH("/tai-chinh-buu-chinh")
    ;
    private final String url;

    WapperMenuItem(String url) {
        this.url = url;
    }

    public String getValue() {
        return url;
    }
}
