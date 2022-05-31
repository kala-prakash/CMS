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
public class Subject {

    private Long id;
    private String name;
    private Long semId;
    private Long facId;

    public Subject() {
    }

    public Subject(Long id, String name, Long semId, Long facId) {
        this.id = id;
        this.name = name;
        this.semId = semId;
        this.facId = facId;
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

    public Long getSemId() {
        return semId;
    }

    public void setSemId(Long semId) {
        this.semId = semId;
    }

    public Long getFacId() {
        return facId;
    }

    public void setFacId(Long facId) {
        this.facId = facId;
    }
}
