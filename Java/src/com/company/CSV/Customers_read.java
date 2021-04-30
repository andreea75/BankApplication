package com.company.CSV;

import com.company.Customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Customers_read {
    private final static String path = "src/com/company/FilesCSV/Customers.csv";

    public static void ReadCustomer(ArrayList<Customer> customers){
        try {
            BufferedReader bf = new BufferedReader(new FileReader(path));
            String line ;
            while((line = bf.readLine()) != null){
                String[] str = line.split(",");
                //customers.add(new Customer(str[0], str[1], str[2], Account [3] ));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
