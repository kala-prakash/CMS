/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.controller;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author kala
 */
public class ContentController {
    static ContentController content = new ContentController();
    
    public void addContent() {

        Scanner scan = new Scanner(System.in);
        
        FilesController.contentName = scan.next();

        File theDir = new File(FilesController.basePath +"/"+FilesController.facultyName +"/"+  FilesController.semesterName+"/"+FilesController.subjectName+"/" +FilesController.contentName);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
}
}
