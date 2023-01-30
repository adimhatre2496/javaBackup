package com.example.AnimeCascade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "AnimeAddress")
@NoArgsConstructor
public class AddressEntity
{

    @Id
    @SequenceGenerator(name = "seq_address_id", sequenceName = "seq_address_id", initialValue = 100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_address_id")
    private Long addressId;

    @Column(name = "address_One")
    private String address1;

    @Column(name = "address_Two")
    private  String address2;

    private String city;
    private String zipCode;

    @OneToOne(mappedBy = "address")
    private PersonEntity person;


}
