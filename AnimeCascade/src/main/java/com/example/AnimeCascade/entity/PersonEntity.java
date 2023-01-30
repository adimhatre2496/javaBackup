package com.example.AnimeCascade.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
@Table(name = "Animeperson")
@NoArgsConstructor
public class  PersonEntity
{

    @Id
    @SequenceGenerator(name = "seq_person_id", sequenceName = "seq_person_id", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_person_id")
    private Long id;

    @Column(name = "first_Name")
    private  String firstName;

    @Column(name = "last_Name")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId")
    private AddressEntity address;

}
