/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.repository;

import com.syntech.model.User;

import java.util.*;

/**
 *
 * @author kala
 */
//yesma abstraction use garne

public class UserRepository {

    private Map<String, User> userMap = new HashMap<>();

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void saveUser(User userDetail) {
        userMap.put(userDetail.getUsername(), userDetail);

    }

    public void removeUser(User userDetail) {
        userMap.remove(userDetail.getUsername());
    }

}
