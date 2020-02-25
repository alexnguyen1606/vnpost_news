package com.vnpost.dto;

import com.vnpost.annotations.Name;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostageFinaceDTO extends BaseDTO {

    private String name;//tên dịch vụ

    private String image;//ảnh

    private String shortDescription;//mô tả ngắng
    @Name("Mô tả dịch vụ")
    private String description;//mô tả dịch vụ

    @Name("Phạm vi dịch vụ")
    private String serviceScope;

    @Name("Cước phí")
    private String rates;

    @Name("Câu hỏi phổ biến")
    private String popularQuestion;
    @Name("Chương trình khuyến mãi")
    private String promotion;

    @Name("Đặc điểm dịch vụ")
    private String serviceSpecification;

    @Name("Dịch vụ cộng thêm")
    private String extraService;//dịch vụ cộng thêm


   @Name("ĐỐi tượng tiết kiệm")
    private String targetSaving;//đối tượng tiết kiệm

   @Name("Lãi xuất")
    private String interestRate;//Lãi xuất

   @Name("Lợi ích dịch vụ")
    private String serviceBenefit;//lợi ích dịch vụ
}
