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

    ///public static Student stud = new Student();
    StudentRepository sr = new StudentRepository();

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
            System.out.println("------------------------");
            System.out.println("Enter the starting year");
            String startDate = input.next();
            System.out.println("------------------------");
            System.out.println("Enter the ending year");
            String endDate = input.next();
          
            Student stud = new Student(null,name,null,null,email,phone,address,startDate,endDate);
            sr.addStudent(stud);
            sr.registerStudentQuery(stud);
            mc.registerMenu();
    }

    public void viewStudentDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        try {
            String viewQuery = "SELECT * from student";
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
            String delete_query = "DELETE FROM student WHERE studentID = ?";
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
        String updateQuery = "UPDATE student set name=? where studentID=?";
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Student Name:");
        String studentName = scan.nextLine();
        System.out.println("Enter the student_Id :");
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
