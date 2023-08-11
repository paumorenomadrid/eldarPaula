package com.example.eldar.application;

import java.time.LocalDate;

import com.example.eldar.model.CreditCard;

public class Ejercicio1 {

    private Ejercicio1() {
    }

    public static void ejercicioUno(){

        //Crear 3 objetos de la clase CreditCard
        CreditCard cc1 = new CreditCard("VISA", "154278523654", "Jonh Doe", LocalDate.of(2013, 8, 4));
        CreditCard cc2 = new CreditCard("VISA", "615427852354", "Mary Ann", LocalDate.of(2029, 5, 4));
        CreditCard cc3 = new CreditCard("VISA", "154654278523", "Lucy Lee", LocalDate.of(2023, 8, 9));

        //Invocar un metodo que devuelva toda la informacion de la tarjeta
        System.out.println(cc1.toString()+ "\n");
        System.out.println(cc2.toString()+ "\n");
        System.out.println(cc3.toString()+ "\n");

        //Informar si una tarjeta es valida para operar

        System.out.println(cc1.isValidInform());
        System.out.println(cc2.isValidInform());
        System.out.println(cc3.isValidInform());

        //Identificar si una tarjeta es distinta de otra
        System.out.println(cc1.isEqualInform(cc2));
        System.out.println(cc3.isEqualInform(cc3));

        //Obtener por medio de un metodo la tasa de una operacion informando la marca e importe
        System.out.println(cc1.getInform(500)+ "\n");
        System.out.println(cc2.getInform(800)+ "\n");
        System.out.println(cc3.getInform(900)+ "\n");
    }

}
    
