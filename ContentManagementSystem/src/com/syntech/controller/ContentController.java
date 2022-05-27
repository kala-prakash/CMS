/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.controller;

import com.syntech.utilities.DirectoryConfig;
import java.util.Scanner;

/**
 *
 * @author kala
 */
public class ContentController {

    
    DirectoryConfig dirConfig = new DirectoryConfig();
    Scanner scan = new Scanner(System.in);

    public void addContent() {
        System.out.println("Enter the Content Name:");
        String contentName = scan.next();
        System.out.println("Enter the File path: ");
        String path = scan.next();
        dirConfig.makeDirectory(path, contentName);

    }

    public void viewContent() {

        System.out.println("Enter the path: ");
        String path = scan.next();
        dirConfig.listDirectory(path);
    }
}
