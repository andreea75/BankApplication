package com.company;

import java.util.Scanner;

public class Login {
    String username;
    String password;
    public Login(){
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your credentials \n");
        System.out.println("Username: ");
        username = scanner.next();
        System.out.println("\nPassword: ");
        password = scanner.next();

        while(!username.equals("Java") || !password.equals("123"))
        {
            System.out.println("\nYour username or password is incorrect.Please try again!");
            System.out.println("Username: ");
            username = scanner.next();
            System.out.println("\nPassword: ");
            password = scanner.next();
        }

        Menu menu = new Menu();
        menu.menu();
    }
}
