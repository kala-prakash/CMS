/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.controller;

import static com.syntech.controller.MenuController.mc;
import com.syntech.utilities.FileUtil;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author kala
 */
public class BaseConfigController {

    public static String facultyName;
    String semesterName;
    String subjectName;
    String contentName;
    String contentType;

    public static final String basePath = "/home/kala/Desktop/Files/";
    FacultyController fac = new FacultyController();
    SemesterController sc = new SemesterController();
    ContentController content = new ContentController();
    ContentTypeController contType = new ContentTypeController();
    FileUtil fp = new FileUtil();

    public void uploadFile() throws IOException, NoSuchAlgorithmException, SQLException {

        Scanner input = new Scanner(System.in);
        String choose;
        System.out.println("---------------------");
        System.out.println("---------------------");
        System.out.println("1) Add Faculties? y/n");
        choose = input.next();
        if (!choose.equals("y")) {
            mc.adminMenu();
        }
        String destPath = "";

        facultyName = fac.addFaculty("Faculty", null);
        System.out.println("---------------------");
        System.out.println("---------------------");
        System.out.println("Add Semester? y/n ");
        choose = input.next();
        if (!choose.equals("y")) {
            mc.adminMenu();
        }
        destPath = destPath + facultyName;
        semesterName = fac.addFaculty("Semester", destPath);
        System.out.println("---------------------");
        System.out.println("---------------------");
        System.out.println("1) Add Subject? y/n ");
        choose = input.next();
        if (!choose.equals("y")) {
            mc.adminMenu();
        }
        destPath = destPath + "/" + semesterName;
        subjectName = fac.addFaculty("Subject", destPath);
        System.out.println("---------------------");
        System.out.println("---------------------");
        System.out.println("Add Content? y/n ");
        choose = input.next();
        if (!choose.equals("y")) {
            mc.adminMenu();
        }
        destPath = destPath + "/" + subjectName;
        contentName = fac.addFaculty("Content", destPath);
        System.out.println("---------------------");
        System.out.println("---------------------");
        System.out.println("Add Content Type?(pdfFile/doc/slides) y/n?");
        choose = input.next();
        if (!choose.equals("y")) {
            mc.adminMenu();
        }
        destPath = destPath + "/" + contentName;
        contentType = fac.addFaculty("Document", destPath);
        System.out.println("---------------------");
        System.out.println("---------------------");
        System.out.println("upload file? y/n??");
        choose = input.next();
        if (!choose.equals("y")) {
            mc.adminMenu();
        }
        destPath = destPath + "/" + contentType+ "/";
        fp.toUpload("srcPath", "fileName", destPath);
        System.out.println("---------------------");
        System.out.println("---------------------");

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
