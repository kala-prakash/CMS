/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.controller;

import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

/**
 *
 * @author kala
 */
public class FacultyController {

    static FacultyController fac = new FacultyController();

    public void addFaculty() {
        System.out.println("Enter the Faculty Name:");
        Scanner scan = new Scanner(System.in);
        FilesController.facultyName = scan.next();

        File theDir = new File(FilesController.basePath + "/" + FilesController.facultyName);

        if (!theDir.exists()) {
            theDir.mkdirs();
        }

    }

    public void viewFaculty() {

        File dir = new File(FilesController.basePath);
        File[] files = dir.listFiles();
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        };
        files = dir.listFiles(fileFilter);
        if (files.length == 0) {
            System.out.println("Either dir does not exist or is not a directory");
        } else {
            for (File filename : files) {
                System.out.println(filename.toString());
            }
        }
    }
}
