package com.magellans.cardtrading.resource.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(	name = "card")
public class CardInfor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String discount;

    @NotBlank
    private String namenetwork;

    @NotBlank
    private String idnetwork;

    @NotBlank
    private Boolean status;

    @NotBlank
    private String appid;

    public String getNameNetwork() {
        return namenetwork;
    }

    public void setNameNetwork(String nameNetwork) {
        this.namenetwork = nameNetwork;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }


    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getidnetwork() {
        return idnetwork;
    }

    public void setidnetwork(String idnetwork) {
        this.idnetwork = idnetwork;
    }


}
