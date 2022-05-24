/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.controller;

import static com.syntech.controller.MenuController.mc;
import static com.syntech.db.Mysqlcon.doConnection;
import com.syntech.model.Student;
import com.syntech.repository.StudentRepository;
import static com.syntech.utilities.Validation.verifyEmail;
import static com.syntech.utilities.Validation.verifyName;
import static com.syntech.utilities.Validation.verifyPhone;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author kala
 */
public class RegistrationController {

    public static Student stud = new Student();
    StudentRepository sr = new StudentRepository();

    public void registerStudent() throws SQLException, IOException, NoSuchAlgorithmException {

        Scanner input = new Scanner(System.in);

        try {
            String sql = "INSERT INTO Student(studentID,name,facultyName,semesterName,email,phone,address,startDate,endDate) VALUES (?,?,?,?,?,?,?,?,?)";

            System.out.println("------------------------");
            System.out.println("Enter the Student name :");
            String name = input.nextLine();
            if (!verifyName(name)) {
                System.out.println("please enter the valid name!!");
                mc.registerMenu();
            }
            System.out.println("------------------------");
            System.out.println("Enter the Student ID");
            System.out.println("------------------------");
            Long studentID = input.nextLong();
            System.out.println("------------------------");
            System.out.println("Enter Email");
            String email = input.next();
            if (!verifyEmail(email)) {
                System.out.println("Please enter the valid email");
                mc.registerMenu();
            }
            System.out.println("------------------------");
            System.out.println("Enter phone no.");
            String phone = input.next();
            if (!verifyPhone(phone)) {
                System.out.println("Invalid phone no.!!");
                mc.registerMenu();
            }
            System.out.println("Enter Address");
            String address = input.next();
            System.out.println("------------------------");
            System.out.println("Enter the Faculty Name");
            System.out.println("a) BCA b) BIM c) CSIT....");
            String facultyName = input.next();
            System.out.println("------------------------");
            System.out.println("Enter the Semester");
            System.out.println("[First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth]");
            String semesterName = input.next();
            if (!(semesterName.equals("First") || semesterName.equals("Second") || semesterName.equals("Third") || semesterName.equals("Fourth"))
                    && !(semesterName.equals("Fifth") || semesterName.equals("Sixth") || semesterName.equals("Seventh") || semesterName.equals("Eighth"))) {
                System.out.println("Invalid Option");
                mc.registerMenu();
            }
            System.out.println("------------------------");
            System.out.println("Enter the starting year");
            String startDate = input.next();
            System.out.println("------------------------");
            System.out.println("Enter the ending year");
            String endDate = input.next();

            // Student stud = new Student(id, name, facultyName, semesterName, email, phone, address, startDate, endDate);
            //sr.addStudent(stud);
            PreparedStatement pstmt = doConnection().prepareStatement(sql);
            pstmt.setLong(1, studentID);
            pstmt.setString(2, name);
            pstmt.setString(3, facultyName);
            pstmt.setString(4, semesterName);
            pstmt.setString(5, email);
            pstmt.setString(6, phone);
            pstmt.setString(7, address);
            pstmt.setString(8, startDate);
            pstmt.setString(9, endDate);

            pstmt.executeUpdate();
            System.out.println("Student added successfully");
            mc.registerMenu();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }

    public void viewStudentDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        try {
            String viewQuery = "SELECT * from Student";
            Statement stmt = doConnection().createStatement();
            ResultSet rs = stmt.executeQuery(viewQuery);
            while (rs.next()) {

                Long studentID = rs.getLong("studentID");
                String Name = rs.getString("Name");
                String facultyName = rs.getString("facultyName");
                String semesterName = rs.getString("semesterName");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String startDate = rs.getString("startDate");
                String endDate = rs.getString("endDate");

                System.out.println(studentID + " " + Name + " " + facultyName + " " + semesterName + "  " + email + " " + phone + " " + address + "  " + startDate + " " + endDate);
            
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }

    public void deleteStudentDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        try {
            String delete_query = "DELETE FROM Student WHERE studentID = ?";
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the Student_Id to delete:");
            Long studentID = scan.nextLong();
            PreparedStatement pstmt = doConnection().prepareStatement(delete_query);
            pstmt.setLong(1, studentID);
            pstmt.executeUpdate();
            System.out.println("Deleted student details with id: " + studentID + " succesfully");
            mc.registerMenu();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }

    public void updateStudentDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        String updateQuery = "UPDATE Student set name=? where studentID=?";
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Student Name:");
        String studentName = scan.nextLine();
        System.out.println("Enter the Student_Id :");
        Long studentID = scan.nextLong();
        try {
            PreparedStatement stmt = doConnection().prepareStatement(updateQuery);
            stmt.setString(1, studentName);
            stmt.setLong(2, studentID);
            stmt.executeUpdate();
            System.out.println("Database updated successfully ");
            mc.registerMenu();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }
}
