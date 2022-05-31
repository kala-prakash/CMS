/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.model;

/**
 *
 * @author kala
 */
public class ContentType {

    private Long id;
    private String name;
    private String extension;
    private Long contentId;

    public ContentType() {
    }

    public ContentType(Long id, String name, String extension, Long contentId) {
        this.id = id;
        this.name = name;
        this.extension = extension;
        this.contentId = contentId;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

}
