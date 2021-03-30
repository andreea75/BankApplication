package com.company;

import java.util.ArrayList;

public class BD {
    ArrayList<Customer> customers = new ArrayList<Customer>();

     Customer getCostumer(int account) {
        return customers.get(account);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
    ArrayList<Customer> getCustomers(){
         return customers;
    }
}
