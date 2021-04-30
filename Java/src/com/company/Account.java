package com.company;

public class Account implements AccountService {
    double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("you have insufficient founds!");
        } else {
            balance -= amount;
            System.out.println("You have withdraw: " + amount);
            System.out.println("You now have a balance of: " + balance);
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("You have deposit: " + amount);
        System.out.println("You now have a balance of: " + balance);

    }

    @Override
    public void transfer_extract(double amount) {
        balance -= amount;
        System.out.println("You now have a balance of: " + balance);
    }
    @Override
    public void transfer_add(double amount) {
        balance += amount;
        System.out.println("You now have a balance of: " + balance);
    }
}
