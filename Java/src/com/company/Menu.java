package com.company;

import com.company.BD.Customer_BD;
import com.company.BD.Deposit_BD;
import com.company.BD.Transfer_BD;
import com.company.BD.Withdraw_BD;
import com.company.CSV.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static Menu menu;

    Scanner scanner = new Scanner(System.in);
    boolean close;
    char option;
    String choice;
    String type;
    ArrayList<Customer> customers = new ArrayList<>();

    private Menu(){

    }

    public static Menu getInstance(){
        if (menu == null){
            menu = new Menu();
        }
        return  menu;
    }

    public void menu() {
        System.out.println("Welcome!");
        while (!close) {
            printMenu();
            Customer_BD.load_customer(customers);
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
                Customer_BD.show_customer();
                break;

            case 'C':
                deleteAccount();

            case 'D':
                Transaction transaction = new Transaction();
                transaction.transaction();
                break;

            case 'E':
                System.out.println("What transactions do you want to see? (deposits/withdraws/transfers/all)");
                choice = scanner.next();
                switch (choice) {
                    case "deposits" -> Deposit_BD.show_deposit();
                    case "withdraws" -> Withdraw_BD.show_withdraw();
                    case "transfers" -> Transfer_BD.show_tranfer();
                    case "all" -> {
                        System.out.println("\nDEPUNERI:");
                        Deposit_BD.show_deposit();
                        System.out.println("\nRETRAGERI:");
                        Withdraw_BD.show_withdraw();
                        System.out.println("\nTRANSFERURI:");
                        Transfer_BD.show_tranfer();
                    }
                }
                break;

            case 'G':
                System.out.println("See you soon.Bye!");
                System.exit(0);
                break;

            case 'F':
                Deposit_BD.delete_deposit();
                Withdraw_BD.delete_withdraw();
                Transfer_BD.delete_transfer();
                break;
        }
    }

    private void deleteAccount() {
        System.out.println("Please select the ID of the account you want to delete: ");
        int id;
        id = scanner.nextInt();
        Customer_BD.delete_customer(customers, id);
    }


    private void createAccount () {
            int id;
            String first_name, last_name;
            String card_number;
            double deposit = 0;

            System.out.println("Select an account type (checking/savings): ");
            type = scanner.next();
            System.out.print("ID: ");
            id = scanner.nextInt();
            System.out.print("First name: ");
            first_name = scanner.next();
            System.out.print("Last name: ");
            last_name = scanner.next();
            System.out.print("Card number: ");
            card_number = scanner.next();

            Account account;
            if (type.equals("checking")) {
                account = new Checking(0);
            } else {
                account = new Savings(0);
            }

            Customer customer = new Customer(id, first_name, last_name, card_number, account, deposit);
            Customer_BD.add_customer(customer);
    }


        private void printMenu () {
            System.out.println("\nPlease choose one of the options below: ");
            System.out.println("A.Create an account\nB.Show details about all the accounts\nC.Delete an account\nD.Make a transaction\nE.Show information about previous transactions\nF.Delete all the transactions\nG.Exit");
        }
}
