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
    
        try{
        String sql = "INSERT INTO student(id,name,fac_id,sem_id,semester_name,faculty_name,email,phone,address,start_date,end_date) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = doConnection().prepareStatement(sql);
        pstmt.setLong(1,1);
        pstmt.setLong(3, );
        pstmt.setLong(4, ); 
        pstmt.setString(7, stud.getEmail());
        pstmt.setString(8, stud.getPhone());
        pstmt.setString(9, stud.getAddress());
        pstmt.setString(10, stud.getStartDate());
        pstmt.setString(11, stud.getEndDate());
        pstmt.executeUpdate();
        System.out.println("Student added successfully");
    }
    catch (SQLException e) {
            System.out.println(e);
    }
            finally {
            doConnection().close();
    }
    }

   
}


