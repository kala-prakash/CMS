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
public class SemesterController {

    static SemesterController sc = new SemesterController();

    public void addSemester() {
        System.out.println("Enter the Semester:");
        System.out.println("[First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth]");
        Scanner scan = new Scanner(System.in);

        FilesController.semesterName = scan.next();

        File theDir = new File(FilesController.basePath + "/" + FilesController.facultyName + "/" + FilesController.semesterName);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
    }

    public void viewSemester() {

        File dir = new File(FilesController.basePath + "/" + FilesController.facultyName);
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
