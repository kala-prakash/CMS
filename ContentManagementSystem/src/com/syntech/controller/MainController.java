package com.syntech.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class MainController {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, SQLException {

        MenuController mc = new MenuController();
       
        mc.mainMenu();
        
        mc.adminMenu();
        
    }
}
