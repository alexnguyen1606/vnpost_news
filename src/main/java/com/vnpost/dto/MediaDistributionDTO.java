package com.vnpost.dto;

import com.vnpost.annotations.Bookmark;
import com.vnpost.annotations.Name;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MediaDistributionDTO extends BaseDTO {

    private String name;//tên dịch vụ

    private String image;//ảnh

    private String shortDescription;//mô tả ngắng

    @Bookmark("servicescope")
    @Name("Phạm vi dịch vụ")
    private String serviceScope;

    @Bookmark("rates")
    @Name("Bảng cước dịch vụ")
    private String rates;

    @Bookmark("popularquestion")
    @Name("Câu hỏi thường gặp")
    private String popularQuestion;

    @Bookmark("servicespecification")
    @Name("Đặc điểm dịch vụ")
    private String serviceSpecification;

    @Bookmark("supplyindustry")
    @Name("Ngành hàng cung cấp")
    private String supplyIndustry;
}
