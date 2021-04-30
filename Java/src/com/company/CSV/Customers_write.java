package com.company.CSV;

import com.company.Account;

import java.io.FileWriter;
import java.io.IOException;

public class Customers_write {
    private final static String path = "src/com/company/FilesCSV/Customers.csv";

    public static void WriteCustomer(String first_name, String last_name, String card_number, Account account){
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter((path),true);
            String stringBuilder = first_name +
                    "," +
                    last_name +
                    "," +
                    card_number +
                    "," +
                    account +
                    "\n";
            fileWriter.write(stringBuilder);
            fileWriter.flush();
            fileWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
