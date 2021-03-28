package com.company;

import java.util.Scanner;

public class Login {
    String username;
    String password;
    public Login(){
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nPlease enter your credentials ");
        System.out.println("\nUsername: ");
        username = scanner.next();
        System.out.println("\nPassword: ");
        password = scanner.next();

        while(!username.equals("Java") || !password.equals("123"))
        {
            System.out.println("\nYour username or password is incorrect.Please try again!\n");
            System.out.println("\nUsername: ");
            username = scanner.next();
            System.out.println("\nPassword: ");
            password = scanner.next();
        }

        Menu menu = new Menu();
        menu.menu();
    }
}
