/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.controller;

import com.syntech.model.Faculty;
import com.syntech.repository.FacultyRepository;
import com.syntech.utilities.DirectoryConfig;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author kala
 */
public class FacultyController {
    Faculty fac = new Faculty();
    FacultyRepository fr = new FacultyRepository();

    DirectoryConfig dirConfig = new DirectoryConfig();

    Scanner scan = new Scanner(System.in);

    public String addFaculty(String table, String path) {
        System.out.println("Enter the " + table + "  Name:");
        String facultyName = scan.next();
        dirConfig.makeDirectory(path, facultyName);
        return facultyName;
    }

    public void addingFaculty() throws SQLException{
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the facultyName:");
        String facultyName = scan.next();
        Faculty fac = new Faculty(null,facultyName);
        fr.addingFaculty(fac);
        fr.addFacultyQuery(fac);
    }
    
    
}
