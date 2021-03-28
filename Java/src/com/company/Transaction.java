package com.company;

import java.util.Scanner;

public class Transaction extends Account{
    int amount;
    int transaction;

    public Transaction(){
    }

    public void transaction() {
        Scanner scanner = new Scanner(System.in);
        int opt;
        System.out.println("\nPlease choose one transaction:");
        System.out.println("\n1.Deposit\n2.Transfer\n3.Show previous transactions: ");
        opt = scanner.nextInt();
        switch (opt) {
            case 1 -> {
                System.out.println("\nWhat sum do you want to deposit?");
                amount = scanner.nextInt();
                Deposit deposit = new Deposit();
                deposit.deposit(amount);
            }
            case 2 -> {
                System.out.println("\nWhat sum do you want to transfer?");
                amount = scanner.nextInt();
                Transfer transfer = new Transfer();
                transfer.transfer(amount);
            }
            case 3 -> {
                if(transaction > 0)
                    System.out.println("Sum you deposited:" +transaction);
                else if(transaction < 0)
                    System.out.println("Sum you transfered: "+transaction);
                else
                    System.out.println("There is no transaction.");

            }
        }
    }
}
