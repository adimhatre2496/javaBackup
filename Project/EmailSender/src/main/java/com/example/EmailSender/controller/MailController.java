package com.example.EmailSender.controller;

import com.example.EmailSender.service.MailService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class MailController
    {
        @Autowired
        private MailService mailService;

    }
