
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kala
 */
public class Demo {
    private String password;

    public Demo(String password) {
        this.password = password;
    }
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

     
    public String get_SHA_512_SecurePassword(String password, String salt){
    String generatedPassword = null;
    try {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt.getBytes(StandardCharsets.UTF_8));
        byte[] bytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        generatedPassword = sb.toString();
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
    return generatedPassword;
}
  

    public static void main(String[] args) throws NoSuchAlgorithmException {
       
   
    
    /*
    //Generating Salt
    //we use the SecureRandom class from java.security
    SecureRandom random = new SecureRandom();
    byte[] salt = new byte[16];
    random.nextBytes (salt);
    //Then we use the MessageDigest class to configure SHA-512 has function with our salt
    MessageDigest md = MessageDigest.getInstance("SHA-512");
    md.update(salt);
    //And with that added, we can now use the digest method  to generate our hashed password
    byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
     //System.out.println("Password:"+ Arrays.toString(hashedPassword));
       */
    }
}
