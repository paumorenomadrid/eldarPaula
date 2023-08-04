package com.example.eldar.controller;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.eldar.model.CreditCard;

@RestController
@CrossOrigin("*")
public class CreditCardController {

    @GetMapping(value = "/creditCard")
    public Map<String, String> getCreditCardInform(@RequestParam String brandName,
                                                   @RequestParam String cardNumber,
                                                   @RequestParam String cardholder,
                                                   @RequestParam LocalDate dueDate,
                                                   @RequestParam float amount) {
        
        CreditCard creditCard = new CreditCard(brandName, cardNumber, cardholder, dueDate);
        float sum = amount * (1 + creditCard.getRate());
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String brand = creditCard.getBrand().getName();
        String rate = decimalFormat.format(creditCard.getRate());
        String total = decimalFormat.format(sum);

        Map<String, String> response = new HashMap<>();
        
        response.put("marca", brand);
        response.put("tasa", rate);
        response.put("importe", total);

        return response;
    }

}