/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.controller;

import static com.syntech.controller.MenuController.mc;
import static com.syntech.db.Mysqlcon.doConnection;
import com.syntech.model.Student;
import com.syntech.repository.FacultyRepository;
import com.syntech.repository.SemesterRepository;
import com.syntech.repository.StudentRepository;
import static com.syntech.utilities.Validation.verifyEmail;
import static com.syntech.utilities.Validation.verifyName;
import static com.syntech.utilities.Validation.verifyPhone;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author kala
 */
public class RegistrationController {

    StudentRepository sr = new StudentRepository();
    SemesterRepository semr = new SemesterRepository();
    FacultyRepository fr = new FacultyRepository();

    public void registerStudent() throws SQLException, IOException, NoSuchAlgorithmException {

        Scanner input = new Scanner(System.in);

        System.out.println("------------------------");
        System.out.println("Enter the Student name :");
        String name = input.nextLine();
        while (!verifyName(name)) {
            System.out.println("please enter the valid name!!");
            name = input.nextLine();
        }
        System.out.println("------------------------");
        System.out.println("Enter Email");
        String email = input.next();
        while (!verifyEmail(email)) {
            System.out.println("Please enter the valid email");
            email = input.next();
        }
        System.out.println("------------------------");
        System.out.println("Enter phone no.");
        String phone = input.next();
        while (!verifyPhone(phone)) {
            System.out.println("pleave enter the valid phone no.!!");
            phone = input.next();
        }
        System.out.println("Enter Address");
        String address = input.next();

        System.out.println("Enter the semester:");
        String semesterName = input.next();
        Long semId = semr.checkSemesterId(semesterName);
        if (semId == null) {
            System.out.println("Did not find id:");
            return;
        }
        System.out.println("Enter the Enter the faculty:");
        String facultyName = input.next();
        Long facId = fr.checkFacultyId(facultyName);
        if (facId == null) {
            System.out.println("Did not find id:");
            return;
        }
        System.out.println("------------------------");
        System.out.println("Enter the starting year");
        String startDate = input.next();
        System.out.println("------------------------");
        System.out.println("Enter the ending year");
        String endDate = input.next();

        Student stud = new Student(null, name, semId, facId, email, phone, address, startDate, endDate);
        sr.addStudent(stud);
        sr.registerStudentQuery(stud);
        mc.registerMenu();
    }
}
