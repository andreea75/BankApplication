package com.company;

import java.util.Scanner;

public class Card extends Menu{
    String first_name;
    String last_name;
    String card_number;
    String expiration_date;
    int cvv_code;

    /*public Card(String first_name,String last_name, String card_number, String expiration_date){
        this.first_name = first_name;
        this.last_name = last_name;
        this.card_number = card_number;
        this.expiration_date = expiration_date;
    }*/

    public void card() {
        System.out.println("\nHere's all the information you need:");
        System.out.println("\nTitular card: "+first_name);
        System.out.println("\nNumber of the card: "+card_number);
        System.out.println("\nExpiration date: "+expiration_date);
        System.out.println("\nCVV code: "+cvv_code);
        menu();
    }


    //getter & setter

}
