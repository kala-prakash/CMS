/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.controller;

import com.syntech.model.Semester;
import com.syntech.repository.SemesterRepository;
import com.syntech.utilities.DirectoryConfig;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author kala
 */
public class SemesterController {

    SemesterRepository semr = new SemesterRepository();

    DirectoryConfig dirConfig = new DirectoryConfig();
    Scanner scan = new Scanner(System.in);
    SemesterRepository sr = new SemesterRepository();

    public String addSemester(String path) {

        System.out.println("Enter the Semester:");
        System.out.println("[First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth]");
        String semesterName = scan.next();
        dirConfig.makeDirectory("/" + path + "/", semesterName);
        return semesterName;
    }

    public void addSem() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Semester Name:");
        String semesterName = scan.next();
        System.out.println("Enter the faculty Name:");
        String facultyName = scan.next();
        Long facId = sr.checkId(facultyName);
        System.out.println(facId);
        if (facId == null) {
            System.out.println("Did not find id:");
            return;
        }
        Semester sem = new Semester(null, semesterName, facId);
        semr.addingSemester(sem);
        semr.semesterQuery(sem);

    }
}
