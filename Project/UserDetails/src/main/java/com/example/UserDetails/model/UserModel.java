package com.example.UserDetails.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel
    {
        private String firstName;
        private String lastName;
        private String email;
        private Date dayMonth;
    }
