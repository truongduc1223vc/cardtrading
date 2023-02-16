package com.magellans.cardtrading.persistence.entity;

import com.magellans.cardtrading.resource.model.CardDetail;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardInforEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter(AccessLevel.NONE)
    private Long id;
    private String discount;
    private String namenetwork;
    private String idnetwork;
    private Boolean status;
    private String appid;
    private List<CardDetail> cardDetailList;
}
