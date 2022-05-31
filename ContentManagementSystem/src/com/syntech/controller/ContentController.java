/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.controller;

import com.syntech.model.Content;
import com.syntech.repository.ContentRepository;
import com.syntech.repository.SubjectRepository;
import com.syntech.utilities.DirectoryConfig;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author kala
 */
public class ContentController {
    
    DirectoryConfig dirConfig = new DirectoryConfig();
    SubjectRepository subr = new SubjectRepository();
    ContentRepository cr = new ContentRepository();
    Scanner scan = new Scanner(System.in);
    
    public void addContent() {
        System.out.println("Enter the Content Name:");
        String contentName = scan.next();
        System.out.println("Enter the File path: ");
        String path = scan.next();
        dirConfig.makeDirectory(path, contentName);
        
    }

    public void addCont() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Content Name:");
        String contentName = scan.next();
        System.out.println("Enter the docPath:");
        String docPath = scan.next();
        System.out.println("Enter the Subject Name:");
        String subjectName = scan.next();
        Long subId = subr.checkSubjectId(subjectName);
        if (subId == null) {
            System.out.println("Did not find id:");
            return;
        }
        
        Content cont = new Content(null, contentName, docPath, subId);
        cr.addingContent(cont);
        cr.contentQuery(cont);
        
    }
    
}
