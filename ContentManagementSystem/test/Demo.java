
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
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
         System.out.println("Enter the Semester");
            System.out.println("[First, Second, Third, Fourth, Fifth, Sixth, Seventh, Eighth]");
            String semesterName = input.next();
            if (!(semesterName.equals("First")||semesterName.equals("Second")||semesterName.equals("Third")||semesterName.equals("Fourth")) && 
                !(semesterName.equals("Fifth")||semesterName.equals("Sixth")||semesterName.equals("Seventh")||semesterName.equals("Eighth"))){
                System.out.println("Invalid Option");
                System.exit(0);
              }
            System.out.println("Successful");
            new Demo();
    }
}
    
  

