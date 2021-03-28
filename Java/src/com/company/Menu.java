package com.company;

import java.util.Scanner;

public class Menu extends Login {

    public Menu() {

    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        char option;
        System.out.println("\nWelcome ");
        System.out.println("\n\nPlease choose one of the options below: ");
        System.out.println("A.Check my balance\nB.Add another card\nC.Show information about my card\nD.Show my transactions\nE.Exit");

        option = scanner.next().charAt(0);
        switch (option) {
            case 'A':
                Account account = new Account();
                account.account();
                menu();
                break;
            case 'B':
                System.out.println("Name: ");
                String name = scanner.next();
                System.out.println("Card number: ");
                String card_number = scanner.next();
                System.out.println("Expiration date: ");
                String expiration_date = scanner.next();
                System.out.println("CVV code: ");
                int cvv_code = scanner.nextInt();

                new Card(name, card_number, expiration_date, cvv_code);

            case 'C':
                Card card = new Card();
                card.card();
                menu();
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
