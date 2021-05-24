package com.company;

import com.company.BD.Customer_BD;
import com.company.BD.Deposit_BD;
import com.company.BD.Transfer_BD;
import com.company.BD.Withdraw_BD;

import java.util.ArrayList;
import java.util.Scanner;

public class Transaction extends Account{
    Scanner scanner = new Scanner(System.in);
    double amount;
    int account,account1;
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Transaction> transactions = new ArrayList<>();

    public Transaction( double amount){
        this.amount = amount;
    }

    public Transaction() {
    }

    public void transaction() {
        int opt;
        System.out.println("\nPlease choose one transaction:");
        System.out.println("\n1.Deposit\n2.Withdraw\n3.Transfer ");
        Customer_BD.load_customer(customers);
        Deposit_BD.load_deposit(transactions);
        Withdraw_BD.load_withdraw(transactions);
        Transfer_BD.load_transfer(transactions);
        opt = scanner.nextInt();
        switch (opt) {
            case 1 ->
                MakeADeposit();

            case 2 ->
                MakeAWithdraw();

            case 3 ->
                MakeATransfer();
        }
    }

    private void MakeATransfer() {
        Customer_BD.show_customer();
        System.out.println("Select the account: ");
        account = scanner.nextInt();
        System.out.println("What sum do you want to transfer?");
        amount = scanner.nextDouble();
        Transfer_BD.add_transfer(amount);
        double b = Customer_BD.select_balance(account) - amount;
        Customer_BD.update_customer(account,b);

        System.out.println("To which account do you want to transfer the money?" );
        Customer_BD.show_customer();
        System.out.println("Select the account: ");
        account1 = scanner.nextInt();
        double b1 = Customer_BD.select_balance(account1) + amount;
        Customer_BD.update_customer(account1,b1);



    }

    private void MakeAWithdraw() {
        Customer_BD.show_customer();
        System.out.println("Select the account: ");
        account = scanner.nextInt();
        if(Customer_BD.select_balance(account) <=  0)
            System.out.println("You're balance is 0. You can't make a withdraw!");
            else {
            System.out.println("What sum do you want to withdraw?");
            amount = scanner.nextDouble();
            if(amount > Customer_BD.select_balance(account))
                System.out.println("You have insuficent founds!");
            else {
                Withdraw_BD.add_withdraw(amount);
                double b = Customer_BD.select_balance(account) - amount;
                Customer_BD.update_customer(account,b);
            }
        }

    }

    private void MakeADeposit() {
        Customer_BD.show_customer();
        System.out.println("Select the account: ");
        account = scanner.nextInt();
        System.out.println("What sum do you want to deposit?");
        amount = scanner.nextDouble();
        Deposit_BD.add_deposit(amount);
       double b = Customer_BD.select_balance(account) + amount;
        Customer_BD.update_customer(account,b);
    }
}
