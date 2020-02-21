package com.vnpost.utils;

import com.vnpost.constant.SystemConstant;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Component
public class FileUtils {
    public String SaveFile(MultipartFile multipartFile){
        String originalName = multipartFile.getOriginalFilename();
        File file = new File(SystemConstant.PATH+originalName);
        try {
            if(!originalName.equals("")){
                multipartFile.transferTo(file);
                String pathImage = SystemConstant.FILE_PATH+originalName;
                return pathImage;
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }finally {
        }
        return "";
    }
}
