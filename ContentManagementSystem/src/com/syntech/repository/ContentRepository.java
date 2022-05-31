/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.repository;

import static com.syntech.db.Mysqlcon.doConnection;
import com.syntech.model.Content;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
