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

        Menu.getInstance().menu();
    }

    @Override
    public void loginSuccessful() {
        while(!username.equals("Admin") || !password.equals("java"))
        {
            System.out.println("\nYour username or password is incorrect.Please try again!\n");
            System.out.print("Username: ");
            username = scanner.next();
            System.out.print("Password: ");
            password = scanner.next();
        }
    }

    @Override
    public void authoriseUser() {
        System.out.println("\nPlease enter your credentials ");
        System.out.print("Username: ");
        username = scanner.next();
        System.out.print("Password: ");
        password = scanner.next();
    }
}
