package com.vnpost.mail;

import com.vnpost.dto.NewsDTO;
import com.vnpost.dto.SubcribDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@Component
public class MailService  {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendNewsSubrib(NewsDTO newsDTO, SubcribDTO subcribDTO){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
            mimeMessageHelper.setTo(subcribDTO.getEmail());

            mimeMessageHelper.setSubject("[VietNam POST News]");
            StringBuilder content =new StringBuilder("<h2>Bài viết mới nhất</h2><br>");
            content.append("<a");
            content.append(" href='");
            content.append("http://localhost:8080/bai-viet/chi-tiet/"+newsDTO.getId());
            content.append("' >");
            content.append(newsDTO.getName());
            content.append("</a>");
            mimeMessageHelper.setText(content.toString(),true);
            javaMailSender.send(mimeMessage);
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
