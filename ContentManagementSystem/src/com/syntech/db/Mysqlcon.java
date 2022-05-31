/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kala
 */
public class Mysqlcon {

    public static Connection doConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/ContentManagementSystem", "root", "toor");

            //multicatch exception
        } catch (ClassNotFoundException | SQLException e) {
            
            System.out.println(e);
        }

        return null;

    }
   

}

