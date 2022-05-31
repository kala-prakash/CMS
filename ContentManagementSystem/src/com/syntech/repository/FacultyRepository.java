/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.repository;

import static com.syntech.controller.MenuController.mc;
import static com.syntech.db.Mysqlcon.doConnection;
import com.syntech.model.Faculty;
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
public class FacultyRepository {

    private List<Faculty> facultyList = new ArrayList<>();

    public List<Faculty> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(List<Faculty> facultyList) {
        this.facultyList = facultyList;
    }

    public void addingFaculty(Faculty facDetails) {
        facultyList.add(facDetails);
    }

    public void addFacultyQuery(Faculty fac) throws SQLException {
        try {
            String sql = "INSERT INTO faculty(name) VALUES (?)";
            PreparedStatement pstmt = doConnection().prepareStatement(sql);
            pstmt.setString(1, fac.getFacultyName());
            pstmt.executeUpdate();
            System.out.println("Added Succefully");

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }

    public void viewFacultyDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        try {
            String viewQuery = "SELECT * from faculty";
            Statement stmt = doConnection().createStatement();
            ResultSet rs = stmt.executeQuery(viewQuery);
            while (rs.next()) {
                Long facultyId = rs.getLong("id");
                String Name = rs.getString("Name");
                System.out.println("id " + facultyId + "++" + "Name " + Name);
                mc.registerMenu();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }

    public void deleteFacultyDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        try {
            String delete_query = "DELETE FROM faculty WHERE id = ?";
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the faculty_id to delete:");
            Long facultyId = scan.nextLong();
            PreparedStatement pstmt = doConnection().prepareStatement(delete_query);
            pstmt.setLong(1, facultyId);
            pstmt.executeUpdate();
            System.out.println("Deleted semester with id: " + facultyId + " succesfully");
            mc.registerMenu();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }

    public void updateFacultyDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        String updateQuery = "UPDATE faculty set name=? where id=?";
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the faculty to be changed:");
        String name = scan.nextLine();
        System.out.println("Enter the faculty_Id :");
        Long facultyId = scan.nextLong();
        try {
            PreparedStatement stmt = doConnection().prepareStatement(updateQuery);
            stmt.setString(1, name);
            stmt.setLong(2, facultyId);
            stmt.executeUpdate();
            System.out.println("Database updated successfully ");
            mc.registerMenu();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }

    public Long checkFacultyId(String name) throws SQLException {
        try {
            Long facId = null;
            String sql = "select id from faculty where name= ?";
            PreparedStatement pstmt = doConnection().prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                facId = rs.getLong(1);
                return facId;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
        return null;
    }

}
