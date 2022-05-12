/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.controller;

import com.syntech.model.User;
import com.syntech.repository.UserRepository;
import static com.syntech.utilities.Validation.verifyPassword;
import static com.syntech.utilities.Validation.verifyUserName;

import java.util.Scanner;

/**
 *
 * @author kala
 */
public class LoginController {

    private Long id;
    private String userName;
    private String password;
    public static UserRepository ur = new UserRepository();
    public static User u = new User();
    public static RegistrationController rc = new RegistrationController();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void login() {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter username: ");
        String inpUser = keyboard.nextLine();
        System.out.println("Enter password: ");
        String inpPass = keyboard.nextLine();
        if (validataionUser(inpUser, inpPass)) {
            System.out.println("login sucess  !!!!");
            System.out.println("------------------");
            rc.registerStudent();
            rc.viewStudentDetails();

        }
        else {
            System.out.println("UserName or Password did not match!!");
        }

        /*if ((inpUser).equals("admin") && (inpPass).equals("123abc")) {
            System.out.println("You are logged in as admin....");
        } else {
            System.out.println("userName or password did not match.!!");
            System.exit(0);
        }
         */
    }

    public boolean validataionUser(String userName, String password) {
        return ur.getUserMap() != null && ur.getUserMap().containsKey(userName) && ur.getUserMap().get(userName).getPassword().equals(password);

    }

    public void signUp() {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter username: ");
        System.out.println("------------------");
        System.out.println("User Name must be atleast 4 characters long");
        String userName = keyboard.next();

        if (!verifyUserName(userName)) {
            System.out.println("Invalid UserName");
            System.out.println("------------------");
            System.exit(0);
        }
        System.out.println("Enter User Id");
        System.out.println("------------------");
        Long userId = keyboard.nextLong();
        
        System.out.println("Enter password:");
        System.out.println("------------------");
        System.out.println("Password must have;");
        System.out.println("a digit\na lower case and upper case\nno spaces allowed\nand must be minimum 8 character long");
        String password = keyboard.next();
        if (!verifyPassword(password)) {
            System.out.println("Try another Password");
            System.out.println("------------------");
            System.exit(0);
        }
        System.out.println("Confirm password:");
        String cpassword = keyboard.next();
        if (password.equals(cpassword)) {
            System.out.println("Password matches!!");
            System.out.println("New user created..");
            User u = new User(userId, userName, password);
            ur.saveUser(u);
        } else {
            System.out.println("Password do not match");
            System.out.println("New user could not be added..Please try again!");
            System.exit(0);
        }

    }
}
