package com.nateprat.repository;

import com.nateprat.AbstractMain;
import com.nateprat.system.SortArray;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Files extends AbstractMain {

    public static final String PICTURE_LOC = "D:\\Documents\\steam_picture test";
    private static String[] acceptedFileTypes = {"jpg", "png", "gif"};
    private SortArray sortArray = new SortArray();


    public ArrayList<File> getListOfFiles() {
        return listOfFiles;
    }

    public void getSortedListOfFiles(String fileLoc, String order) {
        File[] listOfFiles = sortArrayByLastModifiedDate(fileLoc, order);
        ArrayList<File> arrayList = new ArrayList<>(Arrays.asList(listOfFiles));
        AbstractMain.listOfFiles = arrayList;
    }

    private File[] sortArrayByLastModifiedDate(String fileLoc, String order) {
        return sortArray.sortArray(fileLoc, order);
    }

    public void renameFiles(String prefix) {
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

                File file2 = new File(listOfFiles.get(i).getParentFile() + "\\" + prefix + (i + 1) + "." + fileExtension);

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
