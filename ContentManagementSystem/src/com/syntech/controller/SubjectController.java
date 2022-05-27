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
public class SubjectController {

    static SubjectController subControl = new SubjectController();
    DirectoryConfig dirConfig = new DirectoryConfig();
    Scanner scan = new Scanner(System.in);

    public void addSubject() {
        System.out.println("Enter the Subject Name:");
        String subjectName = scan.next();
        System.out.println("Enter the path: ");
        String path = scan.next();
        dirConfig.makeDirectory(path, subjectName);

    }

    public void viewSubject() {

        System.out.println("Enter the path: ");
        String filePath = scan.next();
        dirConfig.listDirectory(filePath);
    }
}
