/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.controller;

import com.syntech.repository.UserRepository;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author kala
 */
public class MenuController {

    LoginController lc = new LoginController();
    RegistrationController rc = new RegistrationController();
    UserRepository ur = new UserRepository();
    BaseConfigController fc = new BaseConfigController();
    static MenuController mc = new MenuController();
    FacultyController facc = new FacultyController();
    SemesterController semc = new SemesterController();
    SubjectController subControl = new SubjectController();
    ContentController cr = new ContentController();
    ContentTypeController contType = new ContentTypeController();

    public void mainMenu() throws SQLException, NoSuchAlgorithmException, IOException {
        String optionSelected;
        System.out.println("----------------------");
        System.out.println("1) Login as admin");
        System.out.println("2) Login as Student");
        System.out.println("3) Exit..");
        System.out.println("----------------------");
        System.out.print("Enter selected option:\n");
        System.out.println("----------------------");
        Scanner input = new Scanner(System.in);
        optionSelected = input.next();
        if (optionSelected.equals("1")) {
            System.out.println("Logging in as admin....");
            System.out.println("------------------");
            lc.loginAdmin();
        } else if (optionSelected.equals("2")) {
            System.out.println("Logging in as student....");
            System.out.println("------------------");
            lc.login();
        } else if (optionSelected.equals("3")) {
            System.out.println("Exiting...");
            System.exit(0);
        } else {
            System.out.println("Enter the valid Option");
            this.mainMenu();

        }
    }

    public void adminMenu() throws NoSuchAlgorithmException, IOException, SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("--------------");
        System.out.println("1) Upload files..");
        System.out.println("2) Delete an existing File?");
        System.out.println("3) Register Student..");
        System.out.println("4) Sign up new user..");
        System.out.println("5) Manage Cirriculam..");
        System.out.println("6) Return to the main menu..");
        System.out.println("--------------");

        String optionSelected = input.next();
        switch (optionSelected) {
            case "1":
                fc.uploadFile();
                break;
            case "2":
                fc.deleteFile();
                break;
            case "3":
                this.registerMenu();
                break;
            case "4":
                lc.signUp();
                break;
            case "5":
                this.cirriculamManagementMenu();
                break;
            case "6":
                this.mainMenu();
            default:
                System.out.println("Please enter the valid optioin");
                this.adminMenu();
                break;
        }
    }

    public void registerMenu() throws SQLException, IOException, NoSuchAlgorithmException {
        Scanner input = new Scanner(System.in);
        int inp;
        System.out.println("1) Add Student ?");
        System.out.println("2) Update Student Details?");
        System.out.println("3) View Student Details ?");
        System.out.println("4) Delete Student Details ?");
        System.out.println("5) Return...");

        inp = input.nextInt();
        switch (inp) {
            case 1:
                rc.registerStudent();
                break;
            case 2:
                rc.updateStudentDetails();
                break;
            case 3:
                rc.viewStudentDetails();
                break;
            case 4:
                rc.deleteStudentDetails();
                break;
            case 5:
                this.adminMenu();
            default:
                this.registerMenu();
                break;
        }
    }

    public void facultyMenu() throws SQLException, NoSuchAlgorithmException, IOException {
        Scanner input = new Scanner(System.in);
        int inp;
        System.out.println("1) Add Faculty?");
        System.out.println("2) Update Faculty details?");
        System.out.println("3) view Student Details ?");
        System.out.println("4) Delete Student Details ?");
        System.out.println("5) Return....");
        inp = input.nextInt();
        switch (inp) {
            case 1:
                facc.addingFaculty();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                this.cirriculamManagementMenu();
                break;
            default:
                this.facultyMenu();
                break;
        }
    }

    public void semesterMenu() throws SQLException, NoSuchAlgorithmException, IOException {
        Scanner input = new Scanner(System.in);
        int inp;
        System.out.println("1) Add Semester?");
        System.out.println("2) Update Semester details?");
        System.out.println("3) Return....");
        inp = input.nextInt();
        switch (inp) {
            case 1:
                semc.addSem();
                break;
            case 2:
                break;
            case 3:
                this.cirriculamManagementMenu();
                break;
            default:
                this.semesterMenu();
                break;
        }
    }
    public void subjectMenu() throws SQLException, NoSuchAlgorithmException, IOException {
        Scanner input = new Scanner(System.in);
        int inp;
        System.out.println("1) Add Subject?");
        System.out.println("2) Update Subject details?");
        System.out.println("3) Return....");
        inp = input.nextInt();
        switch (inp) {
            case 1:
                for(int i =0; i<=8; i++){
                subControl.addSub();
                }
                break;
            case 2:
                break;
            case 3:
                this.cirriculamManagementMenu();
                break;
            default:
                this.subjectMenu();
                break;
        }
    }
    
     public void contentMenu() throws SQLException, NoSuchAlgorithmException, IOException {
        Scanner input = new Scanner(System.in);
        int inp;
        System.out.println("1) Add Content?");
        System.out.println("2) Update Content details?");
        System.out.println("3) Return....");
        inp = input.nextInt();
        switch (inp) {
            case 1:
                cr.addCont();
                break;
            case 2:
                break;
            case 3:
                this.cirriculamManagementMenu();
                break;
            default:
                this.contentMenu();
                break;
        }
    }
     public void contentTypeMenu() throws SQLException, NoSuchAlgorithmException, IOException {
        Scanner input = new Scanner(System.in);
        int inp;
        System.out.println("1) Add Content Type?");
        System.out.println("2) Update Content Type details?");
        System.out.println("3) Return....");
        inp = input.nextInt();
        switch (inp) {
            case 1:
                for(int i = 0; i<= 2; i++){
                contType.addContType();
                }
                break;
            case 2:
                break;
            case 3:
                this.cirriculamManagementMenu();
                break;
            default:
                this.contentTypeMenu();
                break;
        }
    }
     
     public void cirriculamManagementMenu() throws SQLException, NoSuchAlgorithmException, IOException{
     Scanner input = new Scanner(System.in);
         System.out.println("1) Faculty:");
         System.out.println("2) Semester:");
         System.out.println("3) Subject:");
         System.out.println("4) Content:");
         System.out.println("5) ContentType:");
         System.out.println("6) Return...");
         int inp = input.nextInt();
         switch(inp){
             case 1:
                 this.facultyMenu();
                 break;
             case 2:
                this.semesterMenu();
                 break;
             case 3:
                 for(int i = 0; i<=5;i++){
                 this.subjectMenu();
                 }
                 break;
             case 4:
                 this.contentMenu();
                 break;
             case 5:
                 this.contentTypeMenu();
                 break;
             case 6:
                 this.adminMenu();
                 break;
             default :
                 this.cirriculamManagementMenu();
                 break;    
         }
     }
    
}
