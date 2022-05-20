/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.controller;

import com.syntech.repository.UserRepository;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 *
 * @author kala
 */
public class MenuController {

    LoginController lc = new LoginController();
    RegistrationController rc = new RegistrationController();
    UserRepository ur = new UserRepository();
    FilesController fc = new FilesController();
   static MenuController mc = new MenuController();

    public void mainMenu() {
        String optionSelected;
        System.out.println("----------------------");
        System.out.println("1) Login as admin");
        System.out.println("2) Login as Student");
        System.out.println("3) Exit..");
        System.out.println("----------------------");
        System.out.print("Enter selected option:\n");
        System.out.println("----------------------");
        Scanner input = new Scanner(System.in);
        optionSelected = input.next();
        if (optionSelected.equals("1")) {

            System.out.println("Logging in as admin....");
            System.out.println("------------------");
            lc.loginAdmin();
        } else if (optionSelected.equals("2")) {
            System.out.println("Logging in as student....");
            System.out.println("------------------");
            lc.login();
        }else if(optionSelected.equals("3")){
            System.out.println("Exiting...");
            System.exit(0);
        } else {
            System.out.println("Enter the valid Option");
            this.mainMenu();

        }
    }

    public void adminMenu() throws NoSuchAlgorithmException, IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("--------------");
        System.out.println("1) Upload files..");
        System.out.println("2) Delete an existing File?");
        System.out.println("3) Register Student..");
        System.out.println("4) Sign up new user..");
        System.out.println("5) Return to the main menu..");
        System.out.println("--------------");

        String optionSelected = input.next();
        switch (optionSelected) {
            case "1":
                fc.uploadFile();
                break;
            case "2":
                fc.deleteFile();
                break;
            case "3":
                rc.registerStudent();
                rc.viewStudentDetails();
                break;
            case "4":
                lc.signUp();
                break;
            case "5":
                
                this.mainMenu();
            default:
                System.out.println("Please enter the valid optioin");
                this.adminMenu();
                break;
        }
    }

}
