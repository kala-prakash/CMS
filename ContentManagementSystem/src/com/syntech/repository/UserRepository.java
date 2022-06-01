/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.repository;

import static com.syntech.controller.MenuController.mc;
import static com.syntech.db.Mysqlcon.doConnection;
import com.syntech.model.User;
import com.syntech.utilities.HashedPassword;
import static com.syntech.utilities.HashedPassword.isHashingMatched;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.*;

/**
 *
 * @author kala
 */
//yesma abstraction use garne
public class UserRepository {

    HashedPassword hs = new HashedPassword();

    private Map<String, User> userMap = new HashMap<>();

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void saveUser(User userDetail) {
        userMap.put(userDetail.getUsername(), userDetail);

    }

    public void removeUser(User userDetail) {
        userMap.remove(userDetail.getUsername());
    }

    public void userQuery(User usr) throws SQLException {
        try {
   
            String sql = "INSERT INTO user(name,email,user_name,password,user_type) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = doConnection().prepareStatement(sql);
            pstmt.setString(1, usr.getName());
            pstmt.setString(2, usr.getEmail());
            pstmt.setString(3, usr.getUsername());
            pstmt.setString(4, usr.getPassword());
            pstmt.setString(5, usr.getUserType());
            pstmt.executeUpdate();
            System.out.println("New User added.....");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }

    public void viewUserDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        try {
            String viewQuery = "SELECT * from user";
            Statement stmt = doConnection().createStatement();
            ResultSet rs = stmt.executeQuery(viewQuery);
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String userName = rs.getString("user_name");
                String password = rs.getString("password");
                String userType = rs.getString("user_type");
                System.out.println("id " + id + "++" + "Name " + name + "++" + "email " + email + "++" + "user_name " + userName + "++" + "password " + password + "++" + "userType " + userType);
                mc.userManagementMenu();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }

    public void deleteUserDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        try {
            String delete_query = "DELETE FROM user WHERE id = ?";
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the content_id to delete:");
            Long userId = scan.nextLong();
            PreparedStatement pstmt = doConnection().prepareStatement(delete_query);
            pstmt.setLong(1, userId);
            pstmt.executeUpdate();
            System.out.println("Deleted semester with id: " + userId + " succesfully");
            mc.userManagementMenu();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }

    public void updateUserDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        String updateQuery = "UPDATE user set password=? where id=?";
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the new password:");
        String name = scan.nextLine();
        System.out.println("Enter the user Id :");
        Long contentId = scan.nextLong();
        try {
            PreparedStatement stmt = doConnection().prepareStatement(updateQuery);
            stmt.setString(1, name);
            stmt.setLong(2, contentId);
            stmt.executeUpdate();
            System.out.println("Database updated successfully ");
            mc.registerMenu();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }

    public boolean isAdmin(String userName, String password) throws SQLException {
        String sql = "SELECT * FROM user WHERE user_name=? and user_type='Admin'";
        try {
            PreparedStatement stmt = doConnection().prepareStatement(sql);
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String hashedPassword = rs.getString(4);
                boolean isPassMatched = isHashingMatched(password, hashedPassword);
                if (isPassMatched) {
                    return true;
                }
            }
            System.out.println("Invalid username or password");
        } catch (SQLException e) {

            System.out.println(e);
        } finally {
            doConnection().close();
        }
        return false;

    }

    public boolean isUser(String userName, String password) throws SQLException {
        String sql = "SELECT * FROM user WHERE user_name=? and user_type='General'";
        try {
            PreparedStatement stmt = doConnection().prepareStatement(sql);
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String hashedPassword = rs.getString(4);
                boolean isPassMatched = isHashingMatched(password, hashedPassword);
                if (isPassMatched) {
               return true;
            }
            }
            System.out.println("Invalid username or password");
        } catch (SQLException e) {

            System.out.println(e);
        } finally {
            doConnection().close();
        }
        return false;

    }
}
