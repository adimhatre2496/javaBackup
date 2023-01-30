package com.example.UserDetails.controller;

import com.example.UserDetails.entity.UserEntity;
import com.example.UserDetails.model.UserModel;
import com.example.UserDetails.model.UserResponse;
import com.example.UserDetails.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.MonthDay;
import java.util.Date;
import java.util.List;

@RestController
@Log4j2
@RequiredArgsConstructor
public class UserController
    {
        @Autowired
        private UserService userService;




        @PostMapping(path = "/users",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
        private ResponseEntity<UserResponse> createData(@RequestBody UserModel userModel)
        {
            UserResponse userResponse=userService.createData(userModel);
            log.info("UserDetail Posted Successfully with Id "+userResponse);
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        }

       /* *//*@GetMapping(path = "/users/{birthday}",produces = MediaType.APPLICATION_JSON_VALUE)
        private ResponseEntity<UserModel> findByDate(@RequestParam @DateTimeFormat (pattern = "yyyy-MM-dd") Date birthday)
        {
            UserModel userModel=userService.getByDate(birthday);
            log.info("Fetching Complete");
            return new ResponseEntity<>(userModel,HttpStatus.OK);
        }*//*




        @GetMapping(path = "/persons/month-day")
        public ResponseEntity<List<?>> findByDates()
        {
            MonthDay monthDay=MonthDay.now();
            List<?> entityList =userService.findByDayMonth(monthDay);

            log.info("Fetched Successfully");
            return new ResponseEntity<>(entityList, HttpStatus.OK);
        }
*/
    }
