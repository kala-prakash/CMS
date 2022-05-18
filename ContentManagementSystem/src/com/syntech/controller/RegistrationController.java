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

    private Long id;
    private String studentName;
    private String facultyName;
    private String semesterName;
    private String email;
    private String phone;
    private String address;
    private String startDate;
    private String endDate;
    public static Student stud = new Student();
    public static StudentRepository sr = new StudentRepository() {
        @Override
        public void addStudent(Student studentDetail) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

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
