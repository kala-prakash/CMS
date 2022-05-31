/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.repository;

import static com.syntech.controller.MenuController.mc;
import static com.syntech.db.Mysqlcon.doConnection;
import com.syntech.model.Subject;
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

    public void viewSubjectDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        try {
            String viewQuery = "SELECT * from subject";
            Statement stmt = doConnection().createStatement();
            ResultSet rs = stmt.executeQuery(viewQuery);
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                Long facultyId = rs.getLong("fac_id");
                Long semesterId = rs.getLong("sem_id");
                System.out.println("id " + id + "++" + "Name " + name + "++" + "faculty_id " + facultyId + "++" + "semester_id " + semesterId);
                mc.registerMenu();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }
    
     public void deleteSubjectDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        try {
            String delete_query = "DELETE FROM subject WHERE id = ?";
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the subject_id to delete:");
            Long subId = scan.nextLong();
            PreparedStatement pstmt = doConnection().prepareStatement(delete_query);
            pstmt.setLong(1, subId);
            pstmt.executeUpdate();
            System.out.println("Deleted semester with id: " + subId + " succesfully");
            mc.registerMenu();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }
     
     public void updateSubjectDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        String updateQuery = "UPDATE subject set name=? where id=?";
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the subject to be changed:");
        String name = scan.nextLine();
        System.out.println("Enter the subject_Id :");
        Long subId = scan.nextLong();
        try {
            PreparedStatement stmt = doConnection().prepareStatement(updateQuery);
            stmt.setString(1, name);
            stmt.setLong(2, subId);
            stmt.executeUpdate();
            System.out.println("Database updated successfully ");
            mc.registerMenu();
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
