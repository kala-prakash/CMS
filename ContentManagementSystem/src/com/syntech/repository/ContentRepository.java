/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.repository;

import static com.syntech.controller.MenuController.mc;
import static com.syntech.db.Mysqlcon.doConnection;
import com.syntech.model.Content;
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
public class ContentRepository {
    private List<Content> contentList = new ArrayList<>();

    public List<Content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }

    public void addingContent(Content contDetails) {
        contentList.add(contDetails);
    }

    public void contentQuery(Content cont) throws SQLException {
        try {
            String sql = "INSERT INTO content(name,doc_path,sub_id) VALUES (?,?,?)";
            PreparedStatement pstmt = doConnection().prepareStatement(sql);
            pstmt.setString(1, cont.getName());
            pstmt.setString(2, cont.getDocPath());
            pstmt.setLong(3, cont.getSubId());
            pstmt.executeUpdate();
            System.out.println("Added Succefully");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }
     public void viewContentDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        try {
            String viewQuery = "SELECT * from content";
            Statement stmt = doConnection().createStatement();
            ResultSet rs = stmt.executeQuery(viewQuery);
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                Long docPath = rs.getLong("doc_path");
                Long subId = rs.getLong("sub_id");
                System.out.println("id " + id + "++" + "Name " + name + "++" + "doc_path" + docPath + "++" + "sub_id " + subId);
                mc.registerMenu();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }
     
      public void deleteContentDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        try {
            String delete_query = "DELETE FROM content WHERE id = ?";
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the content_id to delete:");
            Long contentId = scan.nextLong();
            PreparedStatement pstmt = doConnection().prepareStatement(delete_query);
            pstmt.setLong(1, contentId);
            pstmt.executeUpdate();
            System.out.println("Deleted semester with id: " + contentId + " succesfully");
            mc.registerMenu();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }
 public void updateContentDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        String updateQuery = "UPDATE content set name=? where id=?";
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the content to be changed:");
        String name = scan.nextLine();
        System.out.println("Enter the content_Id :");
        Long contentId = scan.nextLong();
        try {
            PreparedStatement stmt = doConnection().prepareStatement(updateQuery);
            stmt.setString(1, name);
            stmt.setLong(2, contentId);
            stmt.executeUpdate();
            System.out.println("Database updated successfully ");
            mc.registerMenu();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }      
      
    public Long checkContentId(String name) throws SQLException {
        try {
            Long semId = null;
            String sql = "select id from content where name= ?";
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
