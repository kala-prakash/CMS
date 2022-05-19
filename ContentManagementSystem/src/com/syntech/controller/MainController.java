package com.syntech.controller;

import com.syntech.repository.UserRepository;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class MainController {
    

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        while (true) {
            LoginController lc = new LoginController();
            RegistrationController rc = new RegistrationController();
            UserRepository ur = new UserRepository();
            FilesController fc = new FilesController();

            Scanner scanner = new Scanner(System.in);
            String optionSelected;
            System.out.println("----------------------");
            System.out.println("1 for Login as admin");
            System.out.println("2 for Login as Student");
            System.out.println("0 for exit");
            System.out.println("----------------------");
            System.out.print("Enter selected option:\n");
            System.out.println("----------------------");
            optionSelected = scanner.nextLine();
            if (optionSelected.equals("1")) {
                System.out.println("Logging in as admin....");
                System.out.println("------------------");
                lc.loginAdmin();
                System.out.println("--------------");
                System.out.println("--------------");
                System.out.println("1) Upload files..");
                System.out.println("2) Delete an existing File?");
                System.out.println("3) Register Student..");
                System.out.println("4) Sign up new user..");
                System.out.println("--------------");
                System.out.println("--------------");
                optionSelected = scanner.nextLine();
                if (optionSelected.equals("1")) {
                    fc.uploadFile();

                } else if (optionSelected.equals("2")) {
                    fc.deleteFile();
                } else if (optionSelected.equals("3")) {
                    rc.registerStudent();
                    rc.viewStudentDetails();
                } else if (optionSelected.equals("4")) {
                    lc.signUp();

                }

            } else if (optionSelected.equals("2")) {
                System.out.println("Logging in as student....");
                System.out.println("------------------");
                lc.login();

            } else if (optionSelected.equals("0")) {
                System.out.println("Exitting....");
                System.exit(0);
            } else {
                System.out.println("Exitting....");
                System.exit(0);
            }

        }
    }
}
