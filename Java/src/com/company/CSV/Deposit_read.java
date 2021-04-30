package com.company.CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Deposit_read {
    private final static String path = "src/com/company/FilesCSV/Deposit.csv";

    public static void ReadDeposit() {
        BufferedReader bf;
        {
            try {
                bf = new BufferedReader(new FileReader(path));
                String line;
                while ((line = bf.readLine()) != null) {
                    String[] str = line.split(",");
                    System.out.println("Previous deposits :" + str[0]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
