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
public class SemesterController {

    DirectoryConfig dirConfig = new DirectoryConfig();
    Scanner scan = new Scanner(System.in);

    public String addSemester(String path) {

        System.out.println("Enter the Semester:");
        System.out.println("[First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth]");
        String semesterName = scan.next();
        dirConfig.makeDirectory("/" + path + "/", semesterName);
        return semesterName;
    }

    public void viewSemester() {
        System.out.println("Enter the path: ");
        String filePath = scan.next();
        dirConfig.listDirectory(filePath);
    }
}
