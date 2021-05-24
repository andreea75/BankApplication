package com.company.BD;

import com.company.Checking;
import com.company.Customer;
import com.company.Account;
import com.company.Savings;

import java.sql.*;
import java.util.ArrayList;

public class Customer_BD {

    static String url = "jdbc:sqlserver://LAPTOP-RH4EQQC6\\MSSQLSERVER:1433;database=JAVA";
    static  String username = "root";
    static String password = "java";

    public static void load_customer(ArrayList<Customer> customers){
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "select * from Customer";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String card_number = resultSet.getString("card_number");
                String account_type = resultSet.getString("account_type");
                double balance = resultSet.getDouble("balance");
                Account account;
                if (account_type.equals("checking")) {
                    account = new Checking(0);
                } else {
                    account = new Savings(0);
                }
                customers.add(new Customer(id,first_name,last_name,card_number,account,balance));
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void show_customer(){
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "select * from Customer";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                String first_name = resultSet.getString("first_name");
                String last_name = resultSet.getString("last_name");
                String card_number = resultSet.getString("card_number");
                String account_type = resultSet.getString("account_type");
                double balance = resultSet.getDouble("balance");
                System.out.println("ID: "+id+"\nPrenume: "+first_name+"\nNume: "+last_name+"\nSeria cardului: "+card_number+"\nContul: "+account_type+"\nBalance: "+balance+"\n");
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void add_customer(Customer customers){
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            String type = "";
            if(customers.getAccount().getClass().toString().equals("class com.company.Savings"))
                type = "savings";
                        else if(customers.getAccount().getClass().toString().equals("class com.company.Checking"))
                            type = "checking";
            String query = "insert into Customer values ("+customers.getId()+",'"+customers.getFirst_name()+"','"+customers.getLast_name()+"','"+customers.getCard_number()+"','"+type+"',"+ customers.getBalance()+")";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void update_customer(int id, double balance){
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "update Customer set balance = "+balance+" where customer_id = "+id+"";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static double select_balance(int id){
        double b = 0;
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "select balance from Customer where customer_id="+id+"";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                b = resultSet.getDouble("balance");
            }
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return b;
    }

    public static void delete_customer(ArrayList<Customer> customers, int id){
        try {
            Connection con = DriverManager.getConnection(url,username,password);
            String query = "delete from Customer where customer_id= "+id+"";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.execute();
            con.close();
            load_customer(customers);
    }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
