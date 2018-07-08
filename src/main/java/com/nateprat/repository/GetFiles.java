package com.nateprat.repository;

import com.nateprat.AbstractMain;

import java.io.File;
import java.util.ArrayList;

public class GetFiles extends AbstractMain {

    public static final String PICTURE_LOC = "D:\\Documents\\steam_picture test";
    public File[] listOfFiles;

    public void getFiles() {
        File folder = new File(PICTURE_LOC);
        setListOfFiles(folder.listFiles());
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
//                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
//                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
    }

    public File[] getListOfFiles() {
        return listOfFiles;
    }

    public void setListOfFiles(File[] listOfFiles) {
        this.listOfFiles = listOfFiles;
    }
}
