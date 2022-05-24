/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.controller;

import static com.syntech.controller.ContentController.content;
import static com.syntech.controller.ContentTypeController.contType;
import static com.syntech.controller.FacultyController.fac;
import static com.syntech.controller.MenuController.mc;
import static com.syntech.controller.SemesterController.sc;
import static com.syntech.controller.SubjectController.subControl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author kala
 */
public class FilesController {

    public static String basePath = "/home/kala/Desktop/Files/";
    public static String facultyName;
    public static String semesterName;
    public static String subjectName;
    public static String contentName;
    public static String contentType;
    public static String fileName;

    public static String getFacultyName() {
        return facultyName;
    }

    public static String getSemesterName() {
        return semesterName;
    }

    public static String getSubjectName() {
        return subjectName;
    }

    public static String getContentName() {
        return contentName;
    }

    public static String getContentType() {
        return contentType;
    }

    public static String getFileName() {
        return fileName;
    }

    public void uploadFile() throws IOException, NoSuchAlgorithmException, SQLException {

        Scanner input = new Scanner(System.in);
        String choose;

        System.out.println("---------------------");
        fac.viewFaculty();
        System.out.println("---------------------");
        System.out.println("1) Add Faculties? y/n");
        choose = input.next();
        if (!choose.equals("y")) {
            mc.adminMenu();

        }
        fac.addFaculty();
        System.out.println("---------------------");
        sc.viewSemester();
        System.out.println("---------------------");
        System.out.println("Add Semester? y/n ");
        choose = input.next();
        if (!choose.equals("y")) {
            mc.adminMenu();

        }
        sc.addSemester();
        System.out.println("---------------------");
        subControl.viewSubject();
        System.out.println("---------------------");
        System.out.println("1) Add Subject? y/n ");
        choose = input.next();
        if (!choose.equals("y")) {
            mc.adminMenu();
        }
        subControl.addSubject();
        System.out.println("---------------------");
        content.viewContent();
        System.out.println("---------------------");
        System.out.println("1) Add Content? y/n ");
        choose = input.next();
        if (!choose.equals("y")) {
            mc.adminMenu();
        }
        content.addContent();
        System.out.println("---------------------");
        contType.viewContentType();
        System.out.println("---------------------");
        System.out.println("1) Add Content Type(pdf/doc/slides)? y/n ");
        choose = input.next();
        if (!choose.equals("y")) {
            mc.adminMenu();
        }
        contType.addContentType();

        System.out.println("---------------------");
        System.out.println("Enter the source Filepath:");
        String srcPath = input.next();
        System.out.println("Enter the File Name");
        fileName = input.next();

        String destPath = basePath + "/" + facultyName + "/" + semesterName + "/" + subjectName + "/" + contentName + "/" + contentType;

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcPath);
            if (fileName.endsWith(".txt")) {
                File docFile = new File(destPath);
                if (!docFile.exists()) {
                    docFile.mkdirs();
                }
            } else if (fileName.endsWith(".pdf")) {
                File pdfFile = new File(destPath);
                if (!pdfFile.exists()) {
                    pdfFile.mkdirs();
                }
            } else if (fileName.endsWith(".ppt")) {
                File pptFile = new File(destPath);
                if (!pptFile.exists()) {
                    pptFile.mkdirs();
                }
            } else {
                System.out.println("Failed....");
            }

            fos = new FileOutputStream(destPath + "/" + fileName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }

        } finally {
            if (fis != null) {
                fis.close();
            }
            if (fos != null) {
                fos.close();
            }
            System.out.println("Files copied successfully...");
        }

    }

    public void deleteFile() throws NoSuchAlgorithmException, IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the file path:");
        String path = input.next();
        if (!path.equals(path)) {
            System.out.println("Returning to the admin Menu");
            mc.adminMenu();
        } else {
            File f = new File(path);
            f.delete();
        }

    }

}
