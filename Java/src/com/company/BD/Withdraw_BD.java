package com.company.BD;

import com.company.Transaction;

import java.sql.*;
import java.util.ArrayList;

public class Withdraw_BD {

    static String url = "jdbc:sqlserver://LAPTOP-RH4EQQC6\\MSSQLSERVER:1433;database=JAVA";
    static  String username = "root";
    static String password = "java";

    public static void load_withdraw(ArrayList<Transaction> withdraw){
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "select * from Withdraw";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                //int nr_withdraw = resultSet.getInt("nr_withdraw");
                double suma = resultSet.getInt("suma");

                withdraw.add(new Transaction(suma));
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void show_withdraw(){
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "select * from Withdraw";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int nr_withdraw = resultSet.getInt("nr_withdraw");
                double suma = resultSet.getInt("suma");
                System.out.println(+nr_withdraw+". Suma retrasa: "+suma+"");
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void add_withdraw(double amount){
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "insert into Withdraw (suma) values ("+amount+")";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void delete_withdraw(){
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "delete from Withdraw";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
