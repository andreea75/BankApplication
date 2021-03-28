package com.company;

public class Deposit extends Transaction {
    public Deposit(){

    }
    public void deposit(int amount) {
        if(amount != 0) {
            balance = balance + amount;
            transaction = amount;
        }
    }
}
