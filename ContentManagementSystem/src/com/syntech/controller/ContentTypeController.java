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
public class ContentTypeController {

    
    DirectoryConfig dirConfig = new DirectoryConfig();
    Scanner scan = new Scanner(System.in);

    public void addContentType() {
        System.out.println("Enter the content");
        String contentType = scan.next();
        System.out.println("Enter the path");
        String path = scan.next();
        dirConfig.makeDirectory(path, contentType);

    }

    public void viewContentType() {
        System.out.println("Enter the file path");
        String path = scan.next();
        dirConfig.listDirectory(path);
    }
}
