/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author kala
 */
public class FilesController {

    private Long id;
    private String name;
    private String docPath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocPath() {
        return docPath;
    }

    public void setDocPath(String docPath) {
        this.docPath = docPath;
    }

    public void uploadFile() throws IOException {

      Scanner input = new Scanner(System.in);
        
        System.out.println("---------------------");
        System.out.println("---------------------");
        System.out.println("Enter the Faculty Name:");
        System.out.println("a) BCA b) BIM c) CSIT");
        String facultyName = input.next();
        if (!(facultyName.equals("BCA") || facultyName.equals("BIM") || facultyName.equals("CSIT"))) {
            System.out.println("Invalid option!!");
            System.exit(0);
        }
        System.out.println("---------------------");
        System.out.println("Enter the Semester:");
        System.out.println("[First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth]");
        String semesterName = input.next();
        if (!(semesterName.equals("First") || semesterName.equals("Second") || semesterName.equals("Third") || semesterName.equals("Fourth"))
                && !(semesterName.equals("Fifth") || semesterName.equals("Sixth") || semesterName.equals("Seventh") || semesterName.equals("Eighth"))) {
            System.out.println("Invalid Option");
            System.exit(0);
        }
        System.out.println("---------------------");
        System.out.println("Enter the Subject");
        String subName = input.next();
        System.out.println("---------------------");
        System.out.println("Enter the Content id:");
        Long contId = input.nextLong();
        System.out.println("---------------------");
        System.out.println("Enter the File name:");
        String fileName = input.next();
        System.out.println("---------------------");
        System.out.println("Enter the filepath:");
        String doc = input.next();
        
        FileWriter file= new FileWriter(doc+"//"+fileName,true);
        BufferedWriter br= new BufferedWriter(file);

        br.write("Faculty: "+facultyName);
        br.newLine();
        br.write("Semester: "+semesterName);
        br.newLine();
        br.write("Subject: " +subName);
        br.newLine();
        br.write("Content Id: " +contId);
        br.newLine();
        br.flush();
        br.close();
        System.out.println("---------------------");
       
    }
}


       