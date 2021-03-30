package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Transaction extends Account{
    Scanner scanner = new Scanner(System.in);
    double amount;
    int account;
    BD bd = new BD();

    public Transaction(){
    }

    public void transaction() {
        int opt;
        System.out.println("\nPlease choose one transaction:");
        System.out.println("\n1.Deposit\n2.Withdraw\n3.Transfer ");
        opt = scanner.nextInt();
        switch (opt) {
            case 1 -> {
                MakeADeposit();
            }
            case 2 -> {
                MakeAWithdraw();
            }
            case 3 -> {
                /*if(transaction > 0)
                    System.out.println("Sum you deposited:" +transaction);
                else if(transaction < 0)
                    System.out.println("Sum you transfered: "+transaction);
                else
                    System.out.println("There is no transaction.");
*/
            }
        }
    }

    private void MakeAWithdraw() {
        account = selectAccount();
        if(account >= 0) {
            System.out.println("What sum do you want to withdraw?");
            amount = scanner.nextDouble();
            bd.getCostumer(account).getAccount().withdraw(amount);
        }
    }

    private void MakeADeposit() {
        int account = selectAccount();
        if(account >= 0) {
            System.out.println("What sum do you want to deposit?");
            double amount;
            amount = scanner.nextDouble();
            bd.getCostumer(account).getAccount().deposit(amount);
        }
    }

    public int selectAccount() {
        ArrayList<Customer> customers = bd.getCustomers();
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
