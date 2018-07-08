package com.nateprat.repository;

import com.nateprat.AbstractMain;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class GetFiles extends AbstractMain {

    public static final String PICTURE_LOC = "D:\\Documents\\steam_picture test";

    public void getFiles() {
        File folder = new File(PICTURE_LOC);
        setListOfFiles(folder.listFiles());
        for (int i = 0; i < listOfFiles.size(); i++) {
            if (listOfFiles.get(i).isFile()) {
//                System.out.println("File " + listOfFiles.get(i).getName());
            } else if (listOfFiles.get(i).isDirectory()) {
//                System.out.println("Directory " + listOfFiles.get(i).getName());
            }
        }
    }

    public ArrayList<File> getListOfFiles() {
        return listOfFiles;
    }

    public void setListOfFiles(File[] listOfFiles) {
        ArrayList<File> arrayList = new ArrayList<>(Arrays.asList(listOfFiles));
        AbstractMain.listOfFiles = arrayList;
    }
}
