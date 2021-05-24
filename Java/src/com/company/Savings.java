package com.company;

public class Savings extends Account {
    private static String type = "savings";

    public static String getType() {
        return type;
    }

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
