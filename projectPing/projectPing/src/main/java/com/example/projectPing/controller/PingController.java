package com.example.projectPing.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class PingController {

    @GetMapping(path = "/pings",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getPing() // We can use ? in return type
    {
        log.info("Entered Successfully");
        return ResponseEntity.ok().build();
    }
}
