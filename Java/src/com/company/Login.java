package com.company;

import java.util.Scanner;

public  class Login implements LoginService {
    String username;
    String password;

    Scanner scanner = new Scanner(System.in);
    public Login(){
    }

    public void login() {

        authoriseUser();
        loginSuccessful();

        Menu menu = new Menu();
        menu.menu();
    }

    @Override
    public void loginSuccessful() {
        while(!username.equals("Java") || !password.equals("123"))
        {
            System.out.println("\nYour username or password is incorrect.Please try again!\n");
            System.out.println("\nUsername: ");
            username = scanner.next();
            System.out.println("\nPassword: ");
            password = scanner.next();
        }
    }

    @Override
    public void authoriseUser() {
        System.out.println("\nPlease enter your credentials ");
        System.out.println("\nUsername: ");
        username = scanner.next();
        System.out.println("\nPassword: ");
        password = scanner.next();
    }
}
