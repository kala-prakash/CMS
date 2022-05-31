/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.repository;

import static com.syntech.db.Mysqlcon.doConnection;
import com.syntech.model.Subject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kala
 */
public class SubjectRepository {

    private List<Subject> subjectList = new ArrayList<>();

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public void addingSubject(Subject subDetails) {
        subjectList.add(subDetails);
    }

    public void subjectQuery(Subject sub) throws SQLException {
        try {
            String sql = "INSERT INTO subject(name,sem_id,fac_id) VALUES (?,?,?)";
            PreparedStatement pstmt = doConnection().prepareStatement(sql);
            pstmt.setString(1, sub.getName());
            pstmt.setLong(2, sub.getSemId());
            pstmt.setLong(3, sub.getFacId());
            pstmt.executeUpdate();
            System.out.println("Added Succefully");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }

    public Long checkSubjectId(String name) throws SQLException {
        try {
            Long semId = null;
            String sql = "select id from subject where name= ?";
            PreparedStatement pstmt = doConnection().prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                semId = rs.getLong(1);
                return semId;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
        return null;
    }

}
