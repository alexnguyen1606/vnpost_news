package com.vnpost.dto;

import com.vnpost.annotations.Bookmark;
import com.vnpost.annotations.Name;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class DeliveryServiceDTO extends BaseDTO {
    private PostageDeliveryDTO postageDelivery;

    private String image;

    private String name;//tên dịch vụ


    private String shortDescription;//mô tả ngắng
    private String content;
    private MultipartFile multipartFile;
//    @Bookmark("description")
//    @Name("Mô tả dịch vụ")
//    private String description;//mô tả dịch vụ
//
//    @Bookmark("servicescope")
//    @Name("Phạm vi dịch vụ")
//    private String serviceScope;
//
//    @Bookmark("volumndimension")
//    @Name("Quy định về kích thước khối lượng")
//    private String volumnDimension;
//
//    @Bookmark("complaincompension")
//    @Name("Khiếu nại, bồi thường")
//    private String complainCompension;
//
//    @Bookmark("rates")
//    @Name("Cước phí")
//    private String rates;
//
//    @Bookmark("specialservice")
//    @Name("Dịch vụ đặc biệt")
//    private String specialService;
//
//    @Bookmark("exportProcedure")
//    @Name("Thủ tục xuất khẩu")
//    private String exportProcedure;//xuất khẩu
//
//    @Bookmark("timelimit")
//    @Name("Chỉ tiêu thời gian")
//    private String timeLimit;//chỉ tiêu thời gian
//
//    @Bookmark("extraservice")
//    @Name("Dịch vụ cộng thêm")
//    private String extraService;//dịch vụ cộng thêm
//
//    @Bookmark("shippingmethod")
//    @Name("Phương thức vận chuyển")
//    private String shippingMethod;
//
//    @Bookmark("conditionalapproval")
//    @Name("Điều kiện chấp thuận")
//    private String conditionalApproval;
}
