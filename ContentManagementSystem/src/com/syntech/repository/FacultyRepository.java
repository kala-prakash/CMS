/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.repository;

import static com.syntech.db.Mysqlcon.doConnection;
import com.syntech.model.Faculty;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    public void addFacultyQuery(Faculty fac) throws SQLException{
    try{
    String sql = "INSERT INTO faculty(name) VALUES (?)";
    PreparedStatement pstmt = doConnection().prepareStatement(sql);
    pstmt.setString(1, fac.getFacultyName());
    pstmt.executeUpdate();
        System.out.println("Added Succefully");
        
    }
    catch (SQLException e) {
            System.out.println(e);
    }
            finally {
            doConnection().close();
    }
    }
    public Long checkFacultyId(String name) throws SQLException{
        try{
         Long facId=null;
    String sql = "select id from faculty where name= ?";
    PreparedStatement pstmt = doConnection().prepareStatement(sql);
    pstmt.setString(1,name);
    ResultSet rs=pstmt.executeQuery();
    while(rs.next()){
        facId=rs.getLong(1);
        return facId;
    }    
    }        
       catch(SQLException e){
           System.out.println(e);
       }
        finally{
            doConnection().close();           
        }
        return null;   
}

}    

