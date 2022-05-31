/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.repository;

import static com.syntech.controller.MenuController.mc;
import static com.syntech.db.Mysqlcon.doConnection;
import com.syntech.model.Semester;
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
public class SemesterRepository {

    private List<Semester> semesterList = new ArrayList<>();

    public List<Semester> getSemesterList() {
        return semesterList;
    }

    public void setSemesterList(List<Semester> semesterList) {
        this.semesterList = semesterList;
    }

    public void addingSemester(Semester semDetails) {
        semesterList.add(semDetails);
    }

    public void semesterQuery(Semester sem) throws SQLException {
        try {
            String sql = "INSERT INTO semester(name) VALUES (?)";
            PreparedStatement pstmt = doConnection().prepareStatement(sql);
            pstmt.setString(1, sem.getName());
            pstmt.executeUpdate();
            System.out.println("Added Succefully");

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }

    public void viewSemestertDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        try {
            String viewQuery = "SELECT * from semester";
            Statement stmt = doConnection().createStatement();
            ResultSet rs = stmt.executeQuery(viewQuery);
            while (rs.next()) {
                Long semesterId = rs.getLong("id");
                String Name = rs.getString("Name");
                System.out.println("id " + semesterId + "++" + "Name " + Name);
                mc.registerMenu();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }
     public void deleteSemesterDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        try {
            String delete_query = "DELETE FROM semester WHERE id = ?";
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the semester_id to delete:");
            Long semesterId = scan.nextLong();
            PreparedStatement pstmt = doConnection().prepareStatement(delete_query);
            pstmt.setLong(1, semesterId);
            pstmt.executeUpdate();
            System.out.println("Deleted semester with id: " + semesterId + " succesfully");
            mc.registerMenu();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }
      public void updateSemesterDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        String updateQuery = "UPDATE semester set name=? where id=?";
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the semester to be changed:");
        String name = scan.nextLine();
        System.out.println("Enter the semester_Id :");
        Long semesterId = scan.nextLong();
        try {
            PreparedStatement stmt = doConnection().prepareStatement(updateQuery);
            stmt.setString(1, name);
            stmt.setLong(2, semesterId);
            stmt.executeUpdate();
            System.out.println("Database updated successfully ");
            mc.registerMenu();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }


    public Long checkSemesterId(String name) throws SQLException {
        try {
            Long semId = null;
            String sql = "select id from semester where name= ?";
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
