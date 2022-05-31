/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.repository;

import static com.syntech.db.Mysqlcon.doConnection;
import com.syntech.model.Student;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

}
