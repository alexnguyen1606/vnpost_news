package com.vnpost.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class UploadFileUtils {
    private static final String root ="/usr/var/";
    public  void writeOrUpdate(byte[] byteArray,String path){
        File file = new File(StringUtils.substringBeforeLast(root+path,"/"));

        if (!file.exists()){
            file.mkdir();
        }
        try (FileOutputStream fileOutputStream= new FileOutputStream(new File(root+path))){

             fileOutputStream.write(byteArray);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
