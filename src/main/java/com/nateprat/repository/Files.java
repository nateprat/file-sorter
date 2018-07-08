package com.nateprat.repository;

import com.nateprat.AbstractMain;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Files extends AbstractMain{

    public static final String PICTURE_LOC = "D:\\Documents\\steam_picture test";


    public void getFilesInDirectory() {
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

    private static String[] acceptedFileTypes = {"jpg", "png", "gif"};

    public void renameFiles() {
        boolean pictureFile = false;
        for (int i = 0; i < listOfFiles.size(); i++) {
            // File (or directory) with old name
            File file = new File(listOfFiles.get(i).getPath());

            // File (or directory) with new name
            String fileExtension = getFileType(file);

            for (int j = 0; j < acceptedFileTypes.length; j++) {
                if (fileExtension.equalsIgnoreCase(acceptedFileTypes[j])) {
                    pictureFile = true;
                }
            }

            if (pictureFile) {


                File file2 = new File(listOfFiles.get(i).getParentFile() + "\\steam_pic_" + (i + 1) + "." + fileExtension);

//                 Rename file (or directory)
                boolean success = file.renameTo(file2);
//
                if (!success) {
//                 File was not successfully renamed
                }
            }

        }
    }



    private String getFileType(File file){
        return FilenameUtils.getExtension(file.getName());
    }



}
