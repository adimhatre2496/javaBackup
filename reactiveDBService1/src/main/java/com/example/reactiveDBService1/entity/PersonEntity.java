package com.example.reactiveDBService1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "person")
public class PersonEntity
    {
        @Id
        private Long id;

        private String name;

        private String gender;

    }
