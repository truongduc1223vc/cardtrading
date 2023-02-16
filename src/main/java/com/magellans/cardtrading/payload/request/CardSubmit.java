package com.magellans.cardtrading.payload.request;

import javax.validation.constraints.NotBlank;

public class CardSubmit {

    @NotBlank
    private String idCard;

    @NotBlank
    private String nameNetwork;

    @NotBlank
    private String numberCode;

    @NotBlank
    private String numberSerinal;

    @NotBlank
    private Integer nominalvalue;

    @NotBlank
    private String username;

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Integer getNominalvalue() {
        return nominalvalue;
    }

    public void setNominalvalue(Integer nominalvalue) {
        this.nominalvalue = nominalvalue;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNameNetwork() {
        return nameNetwork;
    }

    public void setNameNetwork(String nameNetwork) {
        this.nameNetwork = nameNetwork;
    }

    public String getNumberCode() {
        return numberCode;
    }

    public void setNumberCode(String numberCode) {
        this.numberCode = numberCode;
    }

    public String getNumberSerinal() {
        return numberSerinal;
    }

    public void setNumberSerinal(String numberSerinal) {
        this.numberSerinal = numberSerinal;
    }
}
