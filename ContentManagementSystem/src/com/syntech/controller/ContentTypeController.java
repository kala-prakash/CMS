/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.controller;

import com.syntech.model.ContentType;
import com.syntech.repository.ContentRepository;
import com.syntech.repository.ContentTypeRepository;
import com.syntech.utilities.DirectoryConfig;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author kala
 */
public class ContentTypeController {

    
    DirectoryConfig dirConfig = new DirectoryConfig();
    ContentRepository cr = new ContentRepository();
    ContentType contType = new ContentType();
    ContentTypeRepository contTypeRepo = new ContentTypeRepository();
    Scanner scan = new Scanner(System.in);

    public void addContentType() {
        System.out.println("Enter the content");
        String contentType = scan.next();
        System.out.println("Enter the path");
        String path = scan.next();
        dirConfig.makeDirectory(path, contentType);

    }

     public void addContType() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the ContentType(txt/pdf/ppt):");
        String contTypeName = scan.next();
        System.out.println("What is  the extension:");
        String extension = scan.next();
        System.out.println("Enter the content Name(Notes/Questions/Answers):");
        String contentName = scan.next();
        Long contId = cr.checkContentId(contentName);
        if (contId == null) {
            System.out.println("Did not find id:");
            return;
        }
        
        ContentType contType = new ContentType(null, contTypeName, extension, contId);
        contTypeRepo.addingContentType(contType);
        contTypeRepo.contentTypeQuery(contType);
        
        
    }
}
