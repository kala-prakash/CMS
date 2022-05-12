package com.syntech.controller;

import java.util.Scanner;

public class MainController {

    public static void main(String[] args) {
        while (true) {
            LoginController lc = new LoginController();
           
            Scanner scanner = new Scanner(System.in);
            String optionSelected;
            System.out.println("----------------------");
            System.out.println("1 for Login");
            System.out.println("2 for User Registration");
            System.out.println("-------------");
            System.out.println("0 for exit");
            System.out.println("----------------------");
            System.out.print("Enter selected option:\n");
            System.out.println("----------------------");
            optionSelected = scanner.nextLine();
            if (optionSelected.equals("1")) {
                System.out.println("Logging in....");
                System.out.println("------------------");
                lc.login();
                
            } else if (optionSelected.equals("2")) {
                System.out.println("Signining up new user....");
                System.out.println("------------------");
                lc.signUp();
            } else if (optionSelected.equals("0")) {
                System.exit(0);

            } else {
                System.out.println("Exitting....");
            }

        }
    }
}
