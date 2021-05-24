package com.company;

public class Customer {
    private int id;
    private  String first_name;
    private  String last_name;
    private String card_number;
    private Account account;
    private Double balance;

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getCard_number() {
        return card_number;
    }

    public Double getBalance(){
        return balance;
    }

    public Customer(int id, String first_name, String last_name, String card_number, Account account, Double balance) {
        this.id = id;
       this.first_name = first_name;
       this.last_name = last_name;
       this.card_number = card_number;
       this.account = account;
       this.balance = balance;
    }

    //@Override
    /*public String inf() {
        return "Customer{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", card_number='" + card_number + '\'' +
                ", account=" + account +
                '}';
    }*/

    public Double AccountList() {
        return account.getBalance();
    }

    public Account getAccount(){
        return account;
    }

   }
