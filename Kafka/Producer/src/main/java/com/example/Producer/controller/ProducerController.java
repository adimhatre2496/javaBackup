package com.example.Producer.controller;

import com.example.Producer.service.ProducerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2

public class ProducerController {
    @Autowired

    private ProducerService topicProducer;

    @RequestMapping(value = "/kafka")
    public void send() {
        topicProducer.send("Topic is created");

    }


}
