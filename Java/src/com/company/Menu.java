package com.company;

import com.company.CSV.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private static Menu menu;

    Scanner scanner = new Scanner(System.in);
    Transaction tr = new Transaction();
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
        System.out.println("Welcome ");
        while (!close) {
            printMenu();
            Customers_read.ReadCustomer(customers);
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

                //Customer inf = new Customer();
                //customer.inf
                //inf.inf();
                break;

            case 'C':
                listBalance();
                break;

            case 'D':
                Transaction transaction = new Transaction();
                transaction.transaction();
                break;

            case 'E':
                System.out.println("What transactions do you want to see? (deposits/withdraws/transfers)");
                choice = scanner.next();
                switch (choice) {
                    case "deposits" -> Deposit_read.ReadDeposit();
                    case "withdraws" -> Withdraw_read.ReadWithdraw();
                    case "transfers" -> Transfer_read.ReadTransfer();
                }
                break;

            case 'F':
                System.out.println("See you soon.Bye!");
                System.exit(0);
                break;
        }
    }

    private void listBalance() {
        int account = tr.selectAccount();
        if (account >= 0)
            System.out.println(customers.get(account).getAccount());
        else
            System.out.println("Invalid account selected.");
    }

        private void createAccount () {
            String first_name, last_name;
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
            if (type.equals("checking")) {
                account = new Checking(deposit);
            } else {
                account = new Savings(deposit);
            }
            Customer customer = new Customer(first_name, last_name, card_number, account);
            customers.add(customer);
            Customers_write.WriteCustomer(first_name,last_name,card_number,account);
        }


        private void printMenu () {
            System.out.println("Please choose one of the options below: ");
            System.out.println("A.Create an account\nB.Show details about my accounts\nC.Check my balance\nD.Make a transaction\nE.Show information about my previous transactions\nF.Exit");
        }
    }
