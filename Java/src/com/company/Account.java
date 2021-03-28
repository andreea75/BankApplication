package com.company;

import java.util.Scanner;

public class Account extends Card{
    String iban;
    double balance;

    public void account() {
        System.out.println("Your current balance is: "+balance);
    }
}
