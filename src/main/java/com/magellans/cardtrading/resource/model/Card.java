package com.magellans.cardtrading.resource.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(	name = "ordercard",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "numbercode"),
                @UniqueConstraint(columnNames = "numberserial")
        })
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 120)
    private String numbercode;

    @NotBlank
    @Size(max = 120)
    private String numberserial;

    @NotBlank
    private Integer nominalvalue;

    @NotBlank
    @Size(max = 20)
    private String idcard;

    @NotBlank
    @Size(max = 20)
    private String status;

    @NotBlank
    private String username;

    @NotBlank
    private LocalDateTime createdate;

    public Card(String username, String status, String idcard, Integer nominalvalue, String numberserial, String numbercode, LocalDateTime createdate ) {
        this.username = username;
        this.status = status;
        this.idcard = idcard;
        this.nominalvalue = nominalvalue;
        this.numberserial = numberserial;
        this.numbercode = numbercode;
        this.createdate = createdate;
    }

    public Card() {

    }

    public Integer getNominalvalue() {
        return nominalvalue;
    }

    public void setNominalvalue(Integer nominalvalue) {
        this.nominalvalue = nominalvalue;
    }

    public String getNumbercode() {
        return numbercode;
    }

    public void setNumbercode(String numbercode) {
        this.numbercode = numbercode;
    }

    public String getNumberserial() {
        return numberserial;
    }

    public void setNumberserial(String numberserial) {
        this.numberserial = numberserial;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public LocalDateTime getCreatedate() {
        return createdate;
    }

    public void setCreatedate(LocalDateTime createdate) {
        this.createdate = createdate;
    }
}
