package com.example.EmailSender.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MailService
    {
        @Value("${topic.name.consumer")
        private String topicName;


    }
