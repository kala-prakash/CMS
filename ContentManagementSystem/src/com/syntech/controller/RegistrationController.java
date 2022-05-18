/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.controller;

import com.syntech.model.Student;
import com.syntech.repository.StudentRepository;
import static com.syntech.utilities.Validation.verifyEmail;
import static com.syntech.utilities.Validation.verifyName;
import static com.syntech.utilities.Validation.verifyPhone;
import java.util.Scanner;

/**
 *
 * @author kala
 */
public class RegistrationController {

    public static Student stud = new Student();
    StudentRepository sr = new StudentRepository();

    public void registerStudent() {

        Scanner input = new Scanner(System.in);
        System.out.println("Add Student? y/n");
        String inp = input.nextLine();
        if (inp.equals("y")) {

            System.out.println("------------------------");
            System.out.println("Enter the Student name :");
            String name = input.nextLine();
            if (!verifyName(name)) {
                System.out.println("please enter the valid name!!");
                System.exit(0);
            }
            System.out.println("------------------------");
            System.out.println("Enter the Student ID");
            System.out.println("------------------------");
            Long id = input.nextLong();
            System.out.println("------------------------");
            System.out.println("Enter Email");
            String email = input.next();
            if (!verifyEmail(email)) {
                System.out.println("Please enter the valid email");
                System.exit(0);
            }
            System.out.println("------------------------");
            System.out.println("Enter phone no.");
            String phone = input.next();
            if (!verifyPhone(phone)) {
                System.out.println("Invalid phone no.!!");
                System.exit(0);
            }
            System.out.println("Enter Address");
            String address = input.next();
            System.out.println("------------------------");
            System.out.println("Enter the Faculty Name");
            System.out.println("a) BCA b) BIM c) CSIT");
            String facultyName = input.next();
            if (!(facultyName.equals("BCA") || facultyName.equals("BIM") || facultyName.equals("CSIT"))) {
                System.out.println("Invalid option!!");
                System.exit(0);
            }
            System.out.println("------------------------");
            System.out.println("Enter the Semester");
            System.out.println("[First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth]");
            String semesterName = input.next();
            if (!(semesterName.equals("First") || semesterName.equals("Second") || semesterName.equals("Third") || semesterName.equals("Fourth"))
                    && !(semesterName.equals("Fifth") || semesterName.equals("Sixth") || semesterName.equals("Seventh") || semesterName.equals("Eighth"))) {
                System.out.println("Invalid Option");
                System.exit(0);
            }
            System.out.println("------------------------");
            System.out.println("Enter the starting date");
            String startDate = input.next();
            System.out.println("------------------------");
            System.out.println("Enter the ending date");
            String endDate = input.next();

            System.out.println("Student added successfully");
            Student stud = new Student(id, name, facultyName, semesterName, email, phone, address, startDate, endDate);
            sr.addStudent(stud);

        }
    }

    public void viewStudentDetails() {
        Scanner input = new Scanner(System.in);
        System.out.println("view Students ? y/n");
        String yes = input.next();
        if (!yes.equals("y")) {
            System.out.println("Exitting...");
            System.exit(0);
        } else {
            System.out.println("Student Details:.." + sr.getStudentList());
        }
    }
}
