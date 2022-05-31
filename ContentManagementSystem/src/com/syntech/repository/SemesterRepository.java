/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.repository;

import static com.syntech.db.Mysqlcon.doConnection;
import com.syntech.model.Semester;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    public void semesterQuery(Semester sem) throws SQLException{
    try{
    String sql = "INSERT INTO semester(name) VALUES (?)";
    PreparedStatement pstmt = doConnection().prepareStatement(sql);
    pstmt.setString(1, sem.getName());
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
    
    public Long checkSemesterId(String name) throws SQLException{
        try{
         Long semId=null;
    String sql = "select id from semester where name= ?";
    PreparedStatement pstmt = doConnection().prepareStatement(sql);
    pstmt.setString(1,name);
    ResultSet rs=pstmt.executeQuery();
    while(rs.next()){
        semId=rs.getLong(1);
        return semId;
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
