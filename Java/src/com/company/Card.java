package com.company;

public class Card {
    String name;
    String card_number;
    String expiration_date;
    int cvv_code;

    public Card(String name, String card_number, String expiration_date, int cvv_code) {
        this.name = name;
        this.card_number = card_number;
        this.expiration_date = expiration_date;
        this.cvv_code = cvv_code;
    }

    public Card() {
    }

    public void card() {
        System.out.println("\nHere's all the information you need:");
        System.out.println("\nTitular card: " + name);
        System.out.println("\nNumber of the card: " + card_number);
        System.out.println("\nExpiration date: " + expiration_date);
        System.out.println("\nCVV code: " + cvv_code);
    }

    //getter & setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public int getCvv_code(){
        return cvv_code;
    }

    public void setCvv_code(int cvv_code){
        this.cvv_code = cvv_code;
    }
}
