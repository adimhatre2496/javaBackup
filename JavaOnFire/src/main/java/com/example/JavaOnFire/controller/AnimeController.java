package com.example.JavaOnFire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import xyz.demo.Java8.service.AnimeService.AnimeService;

@RestController
public class AnimeController {

    @Autowired
    private AnimeService animeService;

}
