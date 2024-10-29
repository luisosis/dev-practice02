package com.democrud.democrud.model;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;

    @Column(name = "ape_father")
    private String apeFather;

    @Column(name = "ape_mother")
    private String apeMother;
}
