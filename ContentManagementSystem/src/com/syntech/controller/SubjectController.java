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
public class SubjectController {

    static SubjectController subControl = new SubjectController();

    public void addSubject() {
        System.out.println("Enter the Subject Name:");
        Scanner scan = new Scanner(System.in);

        FilesController.subjectName = scan.next();

        File theDir = new File(FilesController.basePath + "/" + FilesController.facultyName + "/" + FilesController.semesterName + "/" + FilesController.subjectName);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
    }

    public void viewSubject() {

        File dir = new File(FilesController.basePath + "/" + FilesController.facultyName + "/" + FilesController.semesterName);
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
