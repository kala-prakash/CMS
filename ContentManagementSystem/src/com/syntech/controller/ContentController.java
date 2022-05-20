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
public class ContentController {
    static ContentController content = new ContentController();
    
    public void addContent() {
        System.out.println("Enter the Content Name:");
        Scanner scan = new Scanner(System.in);
        
        FilesController.contentName = scan.next();

        File theDir = new File(FilesController.basePath +"/"+FilesController.facultyName +"/"+  FilesController.semesterName+"/"+FilesController.subjectName+"/" +FilesController.contentName);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
    }
     public void viewContent() {

        File dir = new File(FilesController.basePath + "/" + FilesController.facultyName+"/"+FilesController.semesterName+"/"+FilesController.subjectName);
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
