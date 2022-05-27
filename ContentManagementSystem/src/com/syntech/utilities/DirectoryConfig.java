/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syntech.utilities;

import com.syntech.controller.BaseConfigController;
import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author kala
 */
interface Directory {

    public void makeDirectory(String path, String fileName);

    public void listDirectory(String path);
}

public class DirectoryConfig implements Directory {

    @Override
    public void makeDirectory(String path, String folderName) {

        String baseFolder = BaseConfigController.basePath + (path == null || path.isEmpty() ? "" : path);
        File theDir = new File(baseFolder + "/" + folderName);
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
    }

    @Override
    public void listDirectory(String path) {
        File dir = new File(path);
        File[] files = dir.listFiles();
        FileFilter fileFilter = new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        };
        files = dir.listFiles(fileFilter);
        if (files.length == 0) {
            System.out.println("Either dir does not exist or is not a directory");
        } else {
            for (File filename : files) {
                System.out.println(filename.toString());
            }
        }

    }
}
