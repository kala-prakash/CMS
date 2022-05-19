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
public class SemesterController {
    

    
    
    
    static SemesterController sc = new SemesterController();
   
        
      public void addSemester() {
          
        Scanner scan = new Scanner(System.in);
        
        FilesController.semesterName = scan.next();

        File theDir = new File(FilesController.basePath +"/"+FilesController.facultyName +"/"+  FilesController.semesterName);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
    }
}
     
