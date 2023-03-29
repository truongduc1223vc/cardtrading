package com.magellans.cardtrading.resource.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Entity
//@Table(name = "user_link")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "PRODUCTID")
    private String ProductId;
    @Column(name = "PRODUCTNAME")
    private String ProductName;

    @Column(name = "PRICE")
    private Integer Price;

    @Column(name = "CONTENT")
    private String Content;
}
