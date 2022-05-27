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
public class FacultyController {

    DirectoryConfig dirConfig = new DirectoryConfig();

    Scanner scan = new Scanner(System.in);

    public String addFaculty(String table, String path) {
        System.out.println("Enter the " + table + "  Name:");
        String facultyName = scan.next();
        dirConfig.makeDirectory(path, facultyName);
        return facultyName;
    }

    public void viewFaculty() {
        System.out.println("Enter the path: ");
        String filePath = scan.next();
        dirConfig.listDirectory(filePath);

    }
}
