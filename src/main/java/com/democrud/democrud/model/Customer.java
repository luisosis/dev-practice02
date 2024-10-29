package com.democrud.democrud.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Integer id;

    private String name;

//    @OneToMany(mappedBy = "customer")
//    private List<Invoice> invoices;

//    public Customer() {
//        this.invoices = new ArrayList<>();
//    }
//
//    public Customer(Integer id, String name) {
//        this.id = id;
//        this.name = name;
//        this.invoices = new ArrayList<>();
//    }
}
