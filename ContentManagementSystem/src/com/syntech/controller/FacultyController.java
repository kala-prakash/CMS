/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.controller;


import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author kala
 */
public class FacultyController{

    
    

    static FacultyController fac = new FacultyController();

    Scanner scan = new Scanner(System.in);
    
        

    
        
    public void addFaculty(){
        System.out.println("---------------------");
        System.out.println("---------------------");

        FilesController.facultyName = scan.next();

        File theDir = new File(FilesController.basePath +"/"+FilesController.facultyName );

        if (!theDir.exists()) {
            theDir.mkdirs();
        }

    }

    public void viewFaculty() {

        File dir = new File(FilesController.basePath);
        File[] files = dir.listFiles();
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory();
            }
        };
        files = dir.listFiles(fileFilter);
        if (files.length == 0) {
            System.out.println("Either dir does not exist or is not a directory");
        } else {
            for (int i = 0; i < files.length; i++) {
                File filename = files[i];
                System.out.println(filename.toString());
            }
        }
    }

    public void deleteFaculty() throws IOException {
        System.out.println("Enter the Faculty Name to be deleted: ");
        String facultyName = scan.next();
        File file = new File(FilesController.basePath + facultyName);
        if (file.exists()) {
            file.delete();
            System.out.println(facultyName + "...Deleted");
        }

    }
}
