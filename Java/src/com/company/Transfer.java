package com.company;

public class Transfer extends Transaction {
    public Transfer(){
    }

    public void transfer(int amount) {
        if(amount != 0) {
            balance = balance + amount;
            transaction = -amount;
        }
    }
}
