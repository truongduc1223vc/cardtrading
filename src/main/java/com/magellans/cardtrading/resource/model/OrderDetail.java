package com.magellans.cardtrading.resource.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Builder
@Entity
//@Table(name = "user_link")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetail implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "PRODUCTID")
    private String ProductId;
    @Column(name = "APPID")
    private String AppId;

    @Column(name = "BUYDATE")
    private LocalDate BuyDate;

    @Column(name = "DEVICEID")
    private String DeviceId;

    @Column(name = "ACCECTORDER")
    private Integer AccectOrder;
}
