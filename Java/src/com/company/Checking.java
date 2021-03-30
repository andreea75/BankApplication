package com.company;

public class Checking extends Account {
     private static String type = "checking";

    public Checking(double deposit) {
        super();
        this.setBalance(deposit);
    }
    public String toString(){
        return "Account type: "+ type + "\n" +
                "Balance: " +this.getBalance() + "\n";
    }
}
