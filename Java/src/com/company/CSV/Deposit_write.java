package com.company.CSV;

import java.io.FileWriter;
import java.io.IOException;

public class Deposit_write {
    private final static String path = "src/com/company/FilesCSV/Deposit.csv";

    public static void WriteDeposit(Double amount){
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter((path),true);

            fileWriter.write(String.valueOf(amount));
            fileWriter.flush();
            fileWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
