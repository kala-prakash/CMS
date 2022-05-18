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
        System.out.println("Enter the semester name:");
        String semesterName = scan.next();

        File theDir = new File("/home/kala/Desktop/Content/Faculty/" + semesterName);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
    }
}
     
