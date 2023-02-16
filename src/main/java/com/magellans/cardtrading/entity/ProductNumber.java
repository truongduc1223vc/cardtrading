package com.magellans.cardtrading.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductNumber implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "PRODUCTID")
    private String ProductId;
    @Column(name = "PRODUCTNAME")
    private String ProductName;
    @Column(name = "CONTENT")
    private String Content;
    @Column(name = "REGION")
    private String Region;
    @Column(name = "PACKAGEID")
    private String PackageId;
    @Column(name = "PRICE")
    private Integer Price;
    @Column(name = "DETAIL")
    private String Detail;
    @Column(name = "APPID")
    private String AppId;

}

