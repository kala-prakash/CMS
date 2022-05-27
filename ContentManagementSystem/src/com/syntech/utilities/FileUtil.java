/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.utilities;

import com.syntech.controller.BaseConfigController;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author kala
 */
interface CopyPasteFile {

    public void toUpload(String srcPath, String fileName, String destPath) throws FileNotFoundException, IOException;

    public String createDirIfNotExist(String srcPath, String destPath);

    public Boolean isDirExist(String dirPath);

}

public class FileUtil implements CopyPasteFile {

    @Override
    public void toUpload(String srcPath, String fileName, String destPath) throws FileNotFoundException, IOException {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the source Filepath:");
        srcPath = input.next();
        System.out.println("Enter the fileName:");
        fileName = input.next();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {

            fis = new FileInputStream(srcPath);
            destPath = createDirIfNotExist(srcPath, destPath);
            fos = new FileOutputStream(BaseConfigController.basePath + destPath + "/" + fileName);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (fis != null) {
                fis.close();
            }
            if (fos != null) {
                fos.close();
            }
            System.out.println("Successful...");
        }
    }

    /* public void copy(String srcPath, String destPath) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Source Path");
        srcPath = scan.next();
        System.out.println("Enter the Destination Path");
        

        }
     */
    @Override
    public String createDirIfNotExist(String srcPath, String destPath) {

        String srcPathExtension = "";
        String fileExtension = "";
        int i = srcPath.lastIndexOf('.');
        if (i > 0) {
            srcPathExtension = srcPath.substring(i + 1);
        }
        String[] dests = destPath.split("/");
        fileExtension = dests[dests.length - 1];
        if (!srcPathExtension.equals(fileExtension)) {
            if (!isDirExist(srcPathExtension)) {
//                destPath = destPath.replace(fileExtension, srcPathExtension);
//                File theDir = new File(destPath);
//                if (!theDir.exists()) {
//                    theDir.mkdirs();
//                }
                destPath = destPath.replace(fileExtension + "/", "");
                DirectoryConfig directoryConfig = new DirectoryConfig();
                directoryConfig.makeDirectory(destPath, srcPathExtension);
            }

        }
        return destPath;
    }

    @Override
    public Boolean isDirExist(String dirPath) {
        File f = new File(dirPath);
        if (f.isDirectory()) {
            System.out.println("Yes it is present..");
            return true;
        }
        return false;
    }
}
