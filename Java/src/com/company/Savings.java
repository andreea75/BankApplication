package com.company;

public class Savings extends Account {
    private static String type = "savings";

    public Savings(double deposit) {
        super();
        this.setBalance(deposit);
    }

    @Override
    public String toString() {
        return "Account type: " + type + "\n" +
                "Balance: " + this.getBalance() + "\n";
    }
}
