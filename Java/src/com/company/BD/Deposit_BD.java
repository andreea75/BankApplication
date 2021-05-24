package com.company.BD;

import com.company.*;

import java.sql.*;
import java.util.ArrayList;

public class Deposit_BD {

    static String url = "jdbc:sqlserver://LAPTOP-RH4EQQC6\\MSSQLSERVER:1433;database=JAVA";
    static  String username = "root";
    static String password = "java";

    public static void load_deposit(ArrayList<Transaction> deposit){
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "select * from Deposit";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                double suma = resultSet.getInt("suma");
                deposit.add(new Transaction(suma));
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void show_deposit(){
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "select * from Deposit";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int nr_deposit = resultSet.getInt("nr_deposit");
                double suma = resultSet.getInt("suma");
                System.out.println(+nr_deposit+". Suma depusa: "+suma+"");
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void add_deposit(double amount){
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "insert into Deposit(suma) values ("+amount+")";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void delete_deposit(){
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "delete from Deposit";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
