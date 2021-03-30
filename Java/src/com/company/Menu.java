package com.company;

import java.util.Scanner;

public class Menu {
    boolean close;
    char option;

    Scanner scanner = new Scanner(System.in);
    BD bd = new BD();
    Transaction tr = new Transaction();

    public Menu() {
    }

    public void menu() {
        System.out.println("Welcome ");
        while (!close) {
            printMenu();
            option = scanner.next().charAt(0);
            chooseAction(option);
        }
    }

    private void chooseAction(char option) {
        switch (option) {
            case 'A':
                createAccount();
                break;
            case 'B':
                //toString();
                break;

            case 'C':
                listBalance();
                break;

            case 'D':
                Transaction transaction = new Transaction();
                transaction.transaction();
                break;

            case 'E':
                System.out.println("See you soon.Bye!");
                System.exit(0);
                break;
        }
    }

    private void listBalance() {
        int account = tr.selectAccount();
        if (account >= 0)
            System.out.println(bd.getCostumer(account).getAccount());
        else
            System.out.println("Invalid account selected.");
    }

        private void createAccount () {
            String first_name, last_name;
            String type;
            String card_number;
            double deposit = 0;

            System.out.println("Select an account type (checking/savings): ");
            type = scanner.next();
            System.out.println("First name: ");
            first_name = scanner.next();
            System.out.print("Last name: ");
            last_name = scanner.next();
            System.out.print("Card number: ");
            card_number = scanner.next();

            Account account;
            BD bd = new BD();
            if (type.equals("checking")) {
                account = new Checking(deposit);
            } else {
                account = new Savings(deposit);
            }
            Customer customer = new Customer(first_name, last_name, card_number, account);
            bd.addCustomer(customer);
        }


        private void printMenu () {
            System.out.println("Please choose one of the options below: ");
            System.out.println("A.Create an account\nB.Show details about my accounts\nC.Check my balance\nD.Make a transaction\nE.Exit");
        }
    }
