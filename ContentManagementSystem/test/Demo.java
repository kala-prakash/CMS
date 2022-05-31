
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author kala
 */
interface demon {

    public void copy(String srcPath, String destPath);
}

public class Demo implements demon {

    @Override
    public void copy(String srcPath, String destPath) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Source Path");
        srcPath = scan.next();
        System.out.println("Enter the Destination Path");
        destPath = scan.next();
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {

            fis = new FileInputStream(srcPath);

            fos = new FileOutputStream(destPath);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Successful...");
        }

    }
    public static void main(String[] args) {
        Demo d = new Demo();
        d.copy("srcPath","destPath");

    }

}
