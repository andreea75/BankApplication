package com.company;

import java.util.Scanner;

public class Menu extends Login{

    public Menu(){

    }
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        char option;
        System.out.println("\nWelcome " + username);
        System.out.println("\n\nPlease choose one of the options below: ");
        System.out.println("A.Check my balance\nB.Add another card\nC.Show information about my card\nD.Show my transactions\nE.Exit");

        option = scanner.next().charAt(0);
        switch (option) {
            case 'A':
                Account account = new Account();
                account.account();
                break;

            case 'C':
                /*System.out.println("First name: ");
                String first_name = scanner.next();
                System.out.println("Last name: ");
                System.out.println("Card number: ");
                System.out.println("Expiration date: ");*/
                Card card = new Card();
                card.card();

                break;

            case 'D':
                Transaction transaction = new Transaction();
                transaction.transaction();
                break;

            case 'E':
                System.out.println("See you soon.Bye!");
                break;
        }
    }
}
