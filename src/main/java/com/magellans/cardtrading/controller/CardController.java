package com.magellans.cardtrading.controller;


import com.magellans.cardtrading.generic.service.Response;
import com.magellans.cardtrading.payload.request.CardSubmit;
import com.magellans.cardtrading.payload.request.SignupRequest;
import com.magellans.cardtrading.payload.response.MessageResponse;
import com.magellans.cardtrading.repository.CardInforRepository;
import com.magellans.cardtrading.repository.CardRepository;
import com.magellans.cardtrading.repository.UserRepository;
import com.magellans.cardtrading.resource.model.*;
import com.magellans.cardtrading.service.CardInforService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin()
@RestController
@RequestMapping("/api/v1/card")
public class CardController {

    private final String PARAM_AUTHORIZATION = "Authorization";
    public static final Logger logger = LoggerFactory.getLogger(CardController.class);

    @Autowired
    CardRepository cardRepository;

    @Autowired
    CardInforRepository cardInforRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CardInforService cardInforService;

    @PostMapping("/submit")
    public ResponseEntity<?> submitCard(@Valid @RequestBody CardSubmit cardSubmit) {
        try {
            if (userRepository.existsByUsernameAndStatus(cardSubmit.getUsername(), !UserConfig.status)) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Error: Your account has been locked!"));
            }
            if (cardRepository.existsByNumbercode(cardSubmit.getNumberCode())) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Error: NumberCode is already!"));
            }
            if (cardRepository.existsByNumberserial(cardSubmit.getNumberSerinal())) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Error: NumberSerinal is already!"));
            }
            ZoneId vietnam = ZoneId.of("Asia/Ho_Chi_Minh");
            LocalDateTime fullVietNam = LocalDateTime.now(vietnam);
            Card card = new Card(cardSubmit.getUsername(),
                    CardConfig.statusPending,
                    cardSubmit.getIdCard(),
                    cardSubmit.getNominalvalue(),
                    cardSubmit.getNumberSerinal(),
                    cardSubmit.getNumberCode(),
                    fullVietNam);
            cardRepository.save(card);
            return ResponseEntity.ok(new MessageResponse("Submit successfully!"));
            } catch (Exception e) {
    //			e.printStackTrace();
                return Response.exception(e);
            }
    }
    @RequestMapping(value = "/infor", method = RequestMethod.GET)
    public  ResponseEntity getInforCard(@RequestParam(name = "appId", required = true) String appId) {
        try {
            FrontEndRS frontEndRS = cardInforService.getProduct(appId, UserConfig.status);
            return ResponseEntity.ok(frontEndRS);
        } catch (Exception e) {
            return Response.exception(e);
        }
    }

}
