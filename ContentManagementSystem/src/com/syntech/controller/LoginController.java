/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.controller;

import static com.syntech.controller.MenuController.mc;
import static com.syntech.db.Mysqlcon.doConnection;
import com.syntech.model.User;
import com.syntech.repository.UserRepository;
import static com.syntech.utilities.Validation.verifyPassword;
import static com.syntech.utilities.Validation.verifyUserName;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.PreparedStatement;
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

    public void loginAdmin() throws SQLException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter username: ");
        String inpUser = keyboard.nextLine();
        System.out.println("Enter password: ");
        String inpPass = keyboard.nextLine();
        if ((inpUser).equals("admin") && (inpPass).equals("admin")) {
            System.out.println("You are logged in as admin....");
        } else {
            System.out.println("userName or password did not match.!!");
            mc.mainMenu();
        }

    }

    public void login() throws SQLException {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter username: ");
        String inpUser = keyboard.nextLine();
        System.out.println("Enter password: ");
        String inpPass = keyboard.nextLine();
        if (validataionUser(inpUser, inpPass)) {
            System.out.println("login sucess  !!!!");
            System.out.println("------------------");

        } else {
            System.out.println("UserName or Password did not match!!");
            mc.mainMenu();
        }

    }

    public boolean validataionUser(String userName, String password) {
        return ur.getUserMap() != null && ur.getUserMap().containsKey(userName) && ur.getUserMap().get(userName).getPassword().equals(password);

    }

    public void signUp() throws NoSuchAlgorithmException, SQLException {

        Scanner keyboard = new Scanner(System.in);
        byte[] hashedPasswod = null;
        try {
            String sql = "INSERT INTO User(userId,userName,Password) VALUES (?,?,?)";

            System.out.println("Enter username: ");
            System.out.println("------------------");
            System.out.println("User Name must be atleast 4 characters long");
            String userName = keyboard.next();

            while (!verifyUserName(userName)) {
                System.out.println("Invalid UserName");
                System.out.println("------------------");
                userName = keyboard.next();
            }
            System.out.println("Enter User Id");
            System.out.println("------------------");
            Long userId = keyboard.nextLong();

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
                //Generating Salt
                //we use the SecureRandom class from java.security
                SecureRandom random = new SecureRandom();
                byte[] salt = new byte[16];
                random.nextBytes(salt);
                //Then we use the MessageDigest class to configure SHA-512 has function with our salt
                MessageDigest md = MessageDigest.getInstance("SHA-512");
                md.update(salt);
                //And with that added, we can now use the digest method  to generate our hashed password
                byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
                // System.out.println("Hashed Password: "+Arrays.toString(hashedPassword));

                System.out.println("New user created..");
                User u = new User(userId, userName, password);
                ur.saveUser(u);
            } else {
                System.out.println("Password do not match");
                System.out.println("New user could not be added..Please try again!");
                System.exit(0);
            }

            PreparedStatement pstmt = doConnection().prepareStatement(sql);
            pstmt.setLong(1, userId);
            pstmt.setString(2, userName);
            pstmt.setBytes(3, hashedPasswod);
            pstmt.executeUpdate();
        } catch (NoSuchAlgorithmException | SQLException e) {
            System.out.println(e);
            System.out.println("User added successfully..");
        } finally {
            doConnection().close();
        }
    }

}
