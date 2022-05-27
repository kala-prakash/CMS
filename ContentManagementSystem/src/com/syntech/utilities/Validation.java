/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kala
 */
public class Validation {
    
    public static boolean verifyEmail(String email) {
        Pattern p = Pattern.compile("[A-Za-z0-9][A-Za-z0-9_.]*@[A-Za-z0-9]+.([.][A-Za-z]+)+");
        Matcher m = p.matcher(email);
        return (m.find() && m.group().equals(email));
    }

    public static boolean verifyName(String name) {
        Pattern p = Pattern.compile("[a-zA-Z]{4,}(?: [a-zA-Z]+){0,2}$");
        Matcher m = p.matcher(name);
        return (m.find() && m.group().equals(name));
    }

    public static boolean verifyPhone(String phone) {

        Pattern p = Pattern.compile("[7-9][0-9]{9}");
        Matcher m = p.matcher(phone);
        return (m.find() && m.group().equals(phone));
    }
    
    public static boolean verifyPassword(String password){
    Pattern p = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
    Matcher m = p.matcher(password);
    return (m.find() && m.group().equals(password));
    }
    
    public static boolean verifyUserName(String userName){
    Pattern p = Pattern.compile("([a-zA-z0-9]*{4})");
    Matcher m = p.matcher(userName);
    return (m.find()) && m.group().equals(userName);
    }
    
    public static boolean semesterValidation(String name){
        boolean result = false;
    for(EnumSem elem: EnumSem.values()){
                if(name.equalsIgnoreCase(elem.toString())){
                    result =true;
                    break;
                }
            
            }
    return result;
    }
}
