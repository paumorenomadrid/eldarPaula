package com.example.eldar.service;

import com.example.eldar.model.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class CreditCardService {

    public Map<String, String> informService(String brandName, String cardNumber, String cardholder, LocalDate dueDate, float amount) throws DateTimeException {
        CreditCard aux = new CreditCard(brandName, cardNumber, cardholder, dueDate);
        float sum = amount * (1 + aux.getRate());
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String brand = aux.getBrand().getName();
        String rate = decimalFormat.format(aux.getRate());
        String total = decimalFormat.format(sum);

        Map<String, String> response = new HashMap<>();

        response.put("marca",brand);
                response.put("tasa",rate);
                response.put("importe",total);

                return response;
    }
 @Autowired
    CreditCard creditCard;
}
