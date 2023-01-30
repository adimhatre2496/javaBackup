package com.example.UserDetails.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "userdetail")
public class UserEntity
    {
        @Id
        @SequenceGenerator(name = "user_Seq", sequenceName = "user_Seq", initialValue = 1, allocationSize = 1)
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_Seq")
        private Long id;

        private String firstName;
        private String lastName;
        private String email;
        @Temporal(TemporalType.DATE)
        private Date dayMonth;
    }
