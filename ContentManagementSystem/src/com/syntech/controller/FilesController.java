/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.controller;

import static com.syntech.controller.ContentController.content;
import static com.syntech.controller.ContentTypeController.contType;
import static com.syntech.controller.FacultyController.fac;
import static com.syntech.controller.SemesterController.sc;
import static com.syntech.controller.SubjectController.subControl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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

    public void uploadFile() throws IOException {

        Scanner input = new Scanner(System.in);

        System.out.println("---------------------");
        System.out.println("---------------------");
        System.out.println("Faculties: ");
        fac.viewFaculty();
        System.out.println("Enter the Faculty Name:");
        fac.addFaculty();
        System.out.println("Want to delete faculty?? y/n ?");
        String choose = input.next();
        if (choose.equals("y")) {
            fac.deleteFaculty();
        }

        System.out.println("---------------------");
        System.out.println("[First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth]");

        sc.addSemester();

        System.out.println("---------------------");
        System.out.println("Enter the Subject");
        subControl.addSubject();
        System.out.println("---------------------");
        System.out.println("Enter the Content");
        content.addContent();
        System.out.println("---------------------");
        System.out.println("Enter the Content Type");
        contType.addContentType();
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
            

            fos = new FileOutputStream(destPath+"/"+fileName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }

        } finally {
            if(fis != null){
            fis.close();
            }
            if(fos != null){
            fos.close();
            }
            System.out.println("Files copied successfully...");
        }
    }

    public void deleteFile() {
        Scanner input = new Scanner(System.in);
        System.out.println("Delete a file?? y/n");
        String choose = input.next();
        if (!choose.equals("y")) {
            System.out.println("Exitting....");
            System.exit(0);
        } else {
            System.out.println("Enter the file name");
            fileName = input.next();
            System.out.println("Enter the file Path:");
            String path = input.next();
            File f = new File(path + "/" + fileName);

            if (f.delete()) {
                System.out.println(f.getName() + "  Deleted.....");
                System.exit(0);
            } else {
                System.out.println("Failed..");
            }
        }
    }
}
