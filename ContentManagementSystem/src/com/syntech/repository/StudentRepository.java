/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.repository;

import static com.syntech.controller.RegistrationController.stud;
import com.syntech.model.Student;
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
    


}
