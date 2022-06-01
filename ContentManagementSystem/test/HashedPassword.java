
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kala
 */
public class HashedPassword {
    if (password.equals(cpassword)) {
                System.out.println("Password matches!!");
                //Generating Salt
                //we use the SecureRandom class from java.security
                SecureRandom random = new SecureRandom();
                byte[] salt = new byte[16];
                random.nextBytes(salt);
                //Then we use the MessageDigest class to configure SHA-512 has function with our salt
                MessageDigest md = MessageDigest.getInstance("SHA-512");
                md.update(salt);
                //And with that added, we can now use the digest method  to generate our hashed password
                byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
                // System.out.println("Hashed Password: "+Arrays.toString(hashedPassword));
    
}
