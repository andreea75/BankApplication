package com.company.CSV;

import java.io.FileWriter;
import java.io.IOException;

public class Withdraw_write {
    private final static String path = "src/com/company/FilesCSV/Withdraw.csv";

    public static void WriteTransfer(Double amount){
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
