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
public class ContentTypeController {

    static ContentTypeController contType = new ContentTypeController();

    Scanner scan = new Scanner(System.in);
    File theDir;

    public void addContentType() {

        
        FilesController.contentType = scan.next();

        theDir = new File(FilesController.basePath + "/" + FilesController.facultyName + "/" + FilesController.semesterName + "/" + FilesController.subjectName + "/" + FilesController.contentName + "/" + FilesController.contentType);
        if (!theDir.exists()) {
            theDir.mkdirs();
       }
    }
}


       