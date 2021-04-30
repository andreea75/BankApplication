package com.company;

import com.company.CSV.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Transaction extends Account{
    Scanner scanner = new Scanner(System.in);
    double amount;
    int account;
    ArrayList<Customer> customers = new ArrayList<>();
    public Transaction(){
    }

    public void transaction() {
        int opt;
        System.out.println("\nPlease choose one transaction:");
        System.out.println("\n1.Deposit\n2.Withdraw\n3.Transfer ");
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
        account = selectAccount();
        if(account >= 0) {
            System.out.println("What sum do you want to transfer?");
            amount = scanner.nextDouble();
            Transfer_write.WriteTransfer(amount);
            customers.get(account).getAccount().transfer_extract(amount);
        }
        account = selectAccount();
        customers.get(account).getAccount().transfer_add(amount);
    }

    private void MakeAWithdraw() {
        account = selectAccount();
        if(account >= 0) {
            System.out.println("What sum do you want to withdraw?");
            amount = scanner.nextDouble();
            Withdraw_write.WriteTransfer(amount);
            customers.get(account).getAccount().withdraw(amount);
        }
    }

    private void MakeADeposit() {
         account = selectAccount();
        if(account >= 0) {
            System.out.println("What sum do you want to deposit?");
            amount = scanner.nextDouble();
            Deposit_write.WriteDeposit(amount);
            customers.get(account).getAccount().deposit(amount);
        }

    }

    public int selectAccount() {
        if(customers.size() <= 0){
            System.out.println("No customers.");
            return -1;
        }
        System.out.println("Select an account: ");
        for(int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + "." + customers.get(i).AccountList());
        }
        System.out.println("Please choose your option: ");
        account = scanner.nextInt() - 1;
        return 0;
    }

}
