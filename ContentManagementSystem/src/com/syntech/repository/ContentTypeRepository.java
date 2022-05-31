/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.repository;

import static com.syntech.db.Mysqlcon.doConnection;
import com.syntech.model.ContentType;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author kala
 */
public class ContentTypeRepository {
    private List <ContentType> contentTypeList = new ArrayList<>();

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
    
}
