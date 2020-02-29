package com.vnpost.thread;

import com.vnpost.dto.NewsDTO;
import com.vnpost.dto.SubcribDTO;
import com.vnpost.mail.MailService;
import org.springframework.stereotype.Component;


public class SendMailThread extends Thread {
    NewsDTO newsDTO;
    SubcribDTO subcribDTO;
    MailService mailService;
    public SendMailThread(NewsDTO newsDTO,SubcribDTO subcribDTO,MailService mailService) {
        this.newsDTO = newsDTO;
        this.subcribDTO = subcribDTO;
        this.mailService = mailService;
        this.start();
    }

    @Override
    public void run() {
        mailService.sendNewsSubrib(newsDTO,subcribDTO);
    }
}
