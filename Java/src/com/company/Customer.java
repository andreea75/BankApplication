package com.company;

public class Customer {
    private  String first_name;
    private  String last_name;
    private String card_number;
    private Account account;


    public Customer(String first_name, String last_name, String card_number, Account account) {
       this.first_name = first_name;
       this.last_name = last_name;
       this.card_number = card_number;
       this.account = account;
    }

    //@Override
    public String inf() {
        return "Customer{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", card_number='" + card_number + '\'' +
                ", account=" + account +
                '}';
    }

    public Double AccountList() {
        return account.getBalance();
    }

    Account getAccount(){
        return account;
    }

   }
