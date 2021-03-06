/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.controller;

import static com.syntech.controller.MenuController.mc;
import com.syntech.model.User;
import com.syntech.repository.UserRepository;
import static com.syntech.utilities.HashedPassword.hashString;
import static com.syntech.utilities.Validation.verifyPassword;
import static com.syntech.utilities.Validation.verifyUserName;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author kala
 */
public class LoginController {

    public static UserRepository ur = new UserRepository();
    public static User u = new User();
    public static RegistrationController rc = new RegistrationController();

    public void loginAdmin() throws SQLException, NoSuchAlgorithmException, IOException {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter username: ");
        String inpUser = keyboard.nextLine();
        System.out.println("Enter password: ");
        String inpPass = keyboard.nextLine();
        if (ur.isAdmin(inpUser, inpPass)) {
            System.out.println("You are logged in as admin....");
        } else {
            System.out.println("userName or password did not match.!!");
            mc.mainMenu();
        }

    }

    public void login() throws SQLException, NoSuchAlgorithmException, IOException {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter username: ");
        String inpUser = keyboard.nextLine();
        System.out.println("Enter password: ");
        String inpPass = keyboard.nextLine();
        if (ur.isUser(inpUser, inpPass)) {
            System.out.println("Your are Logged in as user");
            mc.adminMenu();
        }
        else System.out.println("userName or password did not match..!!");
        mc.mainMenu();
    }

    public void signUp() throws NoSuchAlgorithmException, SQLException, IOException {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the Name:");
        String name = keyboard.nextLine();
        System.out.println("Enter the email:");
        String email = keyboard.nextLine();
        System.out.println("Enter the userType: Admin/General?");
        String userType = keyboard.next();
        System.out.println("Enter username: ");
        System.out.println("------------------");
        System.out.println("User Name must be atleast 4 characters long");
        String userName = keyboard.next();

        while (!verifyUserName(userName)) {
            System.out.println("Invalid UserName");
            System.out.println("------------------");
            userName = keyboard.next();
        }
        System.out.println("Enter password:");
        System.out.println("------------------");
        System.out.println("Password must have;");
        System.out.println("a digit\na lower case and upper case\nno spaces allowed\nand must be minimum 8 character long");
        String password = keyboard.next();

        while (!verifyPassword(password)) {
            System.out.println("Try another Password");
            System.out.println("------------------");
            password = keyboard.next();
        }
        System.out.println("Confirm password:");
        String cpassword = keyboard.next();
        if (password.equals(cpassword)) {
            System.out.println("Password matches!!");
            String encryptPassword = hashString(password);
            User u = new User(null, name, email, userName, encryptPassword, userType);
            ur.saveUser(u);
            ur.userQuery(u);
            mc.adminMenu();
        } else {
            System.out.println("Password do not match");
            System.out.println("New user could not be added..Please try again!");
            mc.adminMenu();
        }

    }

}
