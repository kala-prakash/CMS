package com.syntech.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class MainController {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        MenuController mc = new MenuController();
       
        mc.mainMenu();
        
        mc.adminMenu();
        
    }
}
