package com.company.BD;

import com.company.Transaction;

import java.sql.*;
import java.util.ArrayList;

public class Transfer_BD {

    static String url = "jdbc:sqlserver://LAPTOP-RH4EQQC6\\MSSQLSERVER:1433;database=JAVA";
    static  String username = "root";
    static String password = "java";

    public static void load_transfer(ArrayList<Transaction> transfer){
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "select * from Transfer";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                double suma = resultSet.getInt("suma");

                transfer.add(new Transaction(suma));
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void show_tranfer(){
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "select * from Transfer";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int nr_transfer = resultSet.getInt("nr_transfer");
                double suma = resultSet.getInt("suma");
                System.out.println(+nr_transfer+". Suma transferata: "+suma+"");
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void add_transfer(double amount){
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "insert into Deposit (suma) values ("+amount+")";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void delete_transfer(){
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "delete from Transfer";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
