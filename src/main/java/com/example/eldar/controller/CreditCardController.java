package com.example.eldar.controller;

import java.time.LocalDate;
import java.util.Map;

import com.example.eldar.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class CreditCardController {

    @GetMapping(value = "/creditCard")
    public Map<String, String> getCreditCardInform(@RequestParam String brandName,
                                                   @RequestParam String cardNumber,
                                                   @RequestParam String cardholder,
                                                   @RequestParam LocalDate dueDate,
                                                   @RequestParam float amount) {

        return creditCardService.informService(brandName, cardNumber, cardholder, dueDate, amount);
    }
    @Autowired
    CreditCardService creditCardService;

}