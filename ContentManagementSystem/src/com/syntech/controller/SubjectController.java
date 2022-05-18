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
public class SubjectController {
    
     public void addsubject() {

       Scanner scan = new Scanner(System.in);
        System.out.println("Enter the faculty name:");
        String subjectName = scan.next();

        File theDir = new File("");
        if (!theDir.exists()) {
            theDir.mkdir();
        }
        }
}

