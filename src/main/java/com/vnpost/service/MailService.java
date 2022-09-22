package com.vnpost.service;

import com.vnpost.dto.NewsDTO;
import com.vnpost.dto.SubcribDTO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IContext;

import javax.mail.internet.MimeMessage;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PACKAGE)
@RequiredArgsConstructor
public class MailService {

    JavaMailSender javaMailSender;
    TemplateEngine templateEngine;

    public void sendNewsSubrib(NewsDTO newsDTO, SubcribDTO subcribDTO) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(subcribDTO.getEmail());
            mimeMessageHelper.setSubject("[VietNam POST News]");

            IContext context = buildContext(newsDTO);
            mimeMessageHelper.setText(templateEngine.process("Template", context), true);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private IContext buildContext(NewsDTO news) {
        Context context = new Context();
        context.setVariable("subject", "[VietNam POST News]");
        context.setVariable("url", "http://localhost:8080/bai-viet/chi-tiet/" + news.getId());
        return context;
    }

}
