/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.controller;

import static com.syntech.controller.FacultyController.fac;
import static com.syntech.controller.SemesterController.sc;
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
        if(choose.equals("y")){
            fac.deleteFaculty();
        }
        
        System.out.println("---------------------");
        System.out.println("[First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth]");
        
        sc.addSemester();
        

       
        System.out.println("---------------------");
        System.out.println("Enter the Subject");
        String subName = input.next();
        System.out.println("---------------------");
        System.out.println("Enter the Content id:");
        Long contId = input.nextLong();
        System.out.println("---------------------");

        System.out.println("---------------------");
        System.out.println("Enter the source Filepath:");
        String srcPath = input.next();
        System.out.println("Enter the destination Filepath:");
        String destPath = input.next();

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcPath);
            fos = new FileOutputStream(destPath);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        } finally {
            fis.close();
            fos.close();
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
            String fileName = input.next();
            System.out.println("Enter the file Path:");
            String path = input.next();
            File f = new File(path + "//" + fileName);

            if (f.delete()) {
                System.out.println(f.getName() + "  Deleted.....");
                System.exit(0);
            } else {
                System.out.println("Failed..");
            }
        }
    }

    public void downloadFile() {

    }

}
