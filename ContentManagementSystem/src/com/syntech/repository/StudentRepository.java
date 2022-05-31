/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.repository;

import static com.syntech.controller.MenuController.mc;
import static com.syntech.db.Mysqlcon.doConnection;
import com.syntech.model.Student;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author kala
 */
public class StudentRepository {

    private List<Student> studentList = new ArrayList<>();

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(Student studentDetail) {
        studentList.add(studentDetail);
    }

    public void registerStudentQuery(Student stud) throws SQLException {

        try {
            String sql = "INSERT INTO student(name,fac_id,sem_id,email,phone,address,start_date,end_date) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = doConnection().prepareStatement(sql);
            pstmt.setString(1, stud.getStudentName());
            pstmt.setLong(2, stud.getFacultyId());
            pstmt.setLong(3, stud.getSemesterId());
            pstmt.setString(4, stud.getEmail());
            pstmt.setString(5, stud.getPhone());
            pstmt.setString(6, stud.getAddress());
            pstmt.setString(7, stud.getStartDate());
            pstmt.setString(8, stud.getEndDate());
            pstmt.executeUpdate();
            System.out.println("Student added successfully");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }

    public void viewStudentDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        try {
            String viewQuery = "SELECT * from student";
            Statement stmt = doConnection().createStatement();
            ResultSet rs = stmt.executeQuery(viewQuery);
            while (rs.next()) {
                Long studentID = rs.getLong("id");
                String Name = rs.getString("Name");
                Long facultyId = rs.getLong("fac_id");
                Long semesterId = rs.getLong("sem_id");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                String startDate = rs.getString("start_date");
                String endDate = rs.getString("end_date");

                System.out.println("id " + studentID + "++" + "Name " + Name + "++" + "faculty_id " + facultyId + "++" + "semester_id " + semesterId + "++" + "email " + email + "++" + "phone " + phone + "++" + "address " + address + "++" + "star_date " + startDate + "++" + "end_date " + endDate);
                mc.registerMenu();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }

    public void updateStudentDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        String updateQuery = "UPDATE student set name=? where id=?";
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name to be changed:");
        String name = scan.nextLine();
        System.out.println("Enter the student_Id :");
        Long studentId = scan.nextLong();
        try {
            PreparedStatement stmt = doConnection().prepareStatement(updateQuery);
            stmt.setString(1, name);
            stmt.setLong(2, studentId);
            stmt.executeUpdate();
            System.out.println("Database updated successfully ");
            mc.registerMenu();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }

    public void deleteStudentDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        try {
            String delete_query = "DELETE FROM student WHERE id = ?";
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

}
