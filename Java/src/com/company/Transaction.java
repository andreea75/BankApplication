package com.company;

import java.util.Scanner;

public class Transaction {

    public Transaction(){
    }

    public void transaction() {
        Scanner scanner = new Scanner(System.in);
        int opt;
        System.out.println("\nPlease choose one transaction:");
        System.out.println("\n1.Deposit\n2.Transfer\n3.Withdrawal");
        opt = scanner.nextInt();
        switch (opt) {
            case 1 -> {
            }
            case 2 -> {
            }
            case 3 -> {

            }
        }
    }
}
