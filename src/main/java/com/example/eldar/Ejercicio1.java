package com.example.eldar;

import java.time.LocalDate;
import java.lang.System;

import com.example.eldar.model.CreditCard;

public class Ejercicio1 {
	
	public static void main(String[] args) {
	
	//Crear 3 objetos de la clase CreditCard
    CreditCard cc1 = new CreditCard("VISA", "154278523654", "Jonh Doe", LocalDate.of(2013, 8, 4));
    CreditCard cc2 = new CreditCard("VISA", "615427852354", "Mary Ann", LocalDate.of(2029, 5, 4));
    CreditCard cc3 = new CreditCard("VISA", "154654278523", "Lucy Lee", LocalDate.of(2023, 8, 9));
    
    //Invocar un metodo que devuelva toda la informacion de la tarjeta
    System.out.println(cc1.toString());
    System.out.println(cc2.toString());
    System.out.println(cc3.toString());
    
    //Informar si una tarjeta es valida para operar
    System.out.println("La tarjeta " + cc1.getCardNumber() + "es valida?" + cc1.isValidCard());
    System.out.println("La tarjeta " + cc2.getCardNumber() + "es valida?" + cc2.isValidCard());
    System.out.println("La tarjeta " + cc3.getCardNumber() + "es valida?" + cc3.isValidCard());
    
    //Identificar si una tarjeta es distinta de otra
    System.out.println("La tarjeta " + cc1.getCardNumber() + "es diferente de" + cc2.getCardNumber() +  "?" +  cc1.equals(cc2));
    System.out.println("La tarjeta " + cc3.getCardNumber() + "es diferente de" + cc3.getCardNumber() +  "?" +  cc3.equals(cc3));
    
    //Obtener por medio de un metodo la tasa de una operacion informando la marca e importe
    System.out.println(cc1.getInform(500));
    System.out.println(cc2.getInform(800));
    System.out.println(cc3.getInform(900));
    
	}
    
}
