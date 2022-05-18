
import java.io.File;
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
public class FacultyController {
    
    

    private static void addFaculty() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the faculty name:");
        String semesterName = scan.next();
        
        File theDir = new File("/home/kala/Desktop/Content/Faculty/");
        if (!theDir.exists()) {
            theDir.mkdir();
        }
    }
    public static void main(String[] args) {
         new FacultyController();
        FacultyController.addFaculty();
    }
    

}
    

