package com.vnpost.utils;

import com.vnpost.utils.constant.SystemConstant;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Component
public class FileUtils {
    public String SaveFile(MultipartFile multipartFile) {

        String originalName = multipartFile.getOriginalFilename();

        String headerName = org.apache.commons.lang3.StringUtils.substringBeforeLast(originalName, ".");
        String nameFile = StringUtils.convert(headerName) + ".jpg";
        File file = new File(SystemConstant.PATH + nameFile);
        try {
            if (!originalName.equals("")) {
                multipartFile.transferTo(file);
                String pathImage = nameFile;
                return pathImage;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
        }
        return "";
    }
}
