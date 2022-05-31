/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.repository;

import static com.syntech.controller.MenuController.mc;
import static com.syntech.db.Mysqlcon.doConnection;
import com.syntech.model.ContentType;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kala
 */
public class ContentTypeRepository {

    private List<ContentType> contentTypeList = new ArrayList<>();

    public List<ContentType> getContentTypeList() {
        return contentTypeList;
    }

    public void setContentList(List<ContentType> contentTypeList) {
        this.contentTypeList = contentTypeList;
    }

    public void addingContentType(ContentType contTypeDetails) {
        contentTypeList.add(contTypeDetails);
    }

    public void contentTypeQuery(ContentType contType) throws SQLException {
        try {
            String sql = "INSERT INTO content_type(name,extension,content_id) VALUES (?,?,?)";
            PreparedStatement pstmt = doConnection().prepareStatement(sql);
            pstmt.setString(1, contType.getName());
            pstmt.setString(2, contType.getExtension());
            pstmt.setLong(3, contType.getContentId());
            pstmt.executeUpdate();
            System.out.println("Added Succefully");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }

    public void viewContentTypeDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        try {
            String viewQuery = "SELECT * from content_type";
            Statement stmt = doConnection().createStatement();
            ResultSet rs = stmt.executeQuery(viewQuery);
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                Long extension = rs.getLong("extension");
                Long contentId = rs.getLong("content_id");
                System.out.println("id " + id + "++" + "Name " + name + "++" + "extension" + extension + "++" + "content_id " + contentId);
                mc.registerMenu();
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }

    public void deleteContentTypeDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        try {
            String delete_query = "DELETE FROM content_type WHERE id = ?";
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the id to delete:");
            Long id = scan.nextLong();
            PreparedStatement pstmt = doConnection().prepareStatement(delete_query);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
            System.out.println("Deleted semester with id: " + id + " succesfully");
            mc.registerMenu();
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            doConnection().close();
        }
    }

    public void updateContentTypeDetails() throws SQLException, IOException, NoSuchAlgorithmException {
        String updateQuery = "UPDATE content_type set name=? where id=?";
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the contentType to be changed:");
        String name = scan.nextLine();
        System.out.println("Enter the contentType_Id :");
        Long id = scan.nextLong();
        try {
            PreparedStatement stmt = doConnection().prepareStatement(updateQuery);
            stmt.setString(1, name);
            stmt.setLong(2, id);
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
