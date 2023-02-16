package com.magellans.cardtrading.resource.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(	name = "carddetail")
public class CardDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String discount;

    @NotBlank
    private String idcard;

    @NotBlank
    private String idnetwork;

    @NotBlank
    private Boolean status;

    @NotBlank
    private String appid;

    @NotBlank
    private String nominalvalue;

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

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getIdnetwork() {
        return idnetwork;
    }

    public void setIdnetwork(String idnetwork) {
        this.idnetwork = idnetwork;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getNominalvalue() {
        return nominalvalue;
    }

    public void setNominalvalue(String nominalvalue) {
        this.nominalvalue = nominalvalue;
    }

}