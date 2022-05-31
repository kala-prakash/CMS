/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.controller;

import com.syntech.model.Subject;
import com.syntech.repository.FacultyRepository;
import com.syntech.repository.SemesterRepository;
import com.syntech.repository.SubjectRepository;
import com.syntech.utilities.DirectoryConfig;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author kala
 */
public class SubjectController {

    static SubjectController subControl = new SubjectController();
    FacultyRepository fr = new FacultyRepository();
    SubjectRepository subr = new SubjectRepository();
    SemesterRepository sr = new SemesterRepository();
    Subject sub = new Subject();
    DirectoryConfig dirConfig = new DirectoryConfig();
    Scanner scan = new Scanner(System.in);

    public void addSubject() {
        System.out.println("Enter the Subject Name:");
        String subjectName = scan.next();
        System.out.println("Enter the path: ");
        String path = scan.next();
        dirConfig.makeDirectory(path, subjectName);
    }

    public void addSub() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Subject Name:");
        String subjectName = scan.next();
        System.out.println("Enter the semester Name:");
        String semesterName = scan.next();
        Long semId = sr.checkSemesterId(semesterName);
        if (semId == null) {
            System.out.println("Did not find id:");
            return;
        }
        System.out.println("Enter the Faculty Name:");
        String facultyName = scan.next();
        Long facId = fr.checkFacultyId(facultyName);
        if (facId == null) {
            System.out.println("Did not find id:");
            return;
        }

        Subject sub = new Subject(null, subjectName, semId, facId);
        subr.addingSubject(sub);
        subr.subjectQuery(sub);

    }

}
