package com.nateprat.repository;

import com.nateprat.AbstractMain;
import com.nateprat.system.SortArray;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Files extends AbstractMain {

    public static final String PICTURE_LOC = "D:\\Documents\\steam_picture test";
    private ArrayList<String> acceptedFileTypes = new ArrayList<>();
    private SortArray sortArray = new SortArray();


    public ArrayList<File> getListOfFiles() {
        return AbstractMain.listOfFiles;
    }

    public void getSortedListOfFiles(String fileLoc, String order, String fileTypes) {
        getAcceptedFileTypes(fileTypes);
        File[] listOfFiles = sortArrayByLastModifiedDate(fileLoc, order);
        ArrayList<File> arrayList = new ArrayList<>(Arrays.asList(listOfFiles));
        AbstractMain.listOfFiles = arrayList;
    }

    private File[] sortArrayByLastModifiedDate(String fileLoc, String order) {
        return sortArray.sortArray(fileLoc, order, acceptedFileTypes);
    }

    public void getAcceptedFileTypes(String fileTypes) {
        acceptedFileTypes.clear();
        String[] fileType = fileTypes.split(",");
        for (String type: fileType) {
            acceptedFileTypes.add(type);
        }
    }

    public void renameFiles(String prefix) {
        for (int i = 0; i < listOfFiles.size(); i++) {
            boolean pictureFile = false;
            // File (or directory) with old name
            File file = new File(listOfFiles.get(i).getPath());

            // File (or directory) with new name
            String fileExtension = getFileType(file);

            if(!acceptedFileTypes.get(0).equalsIgnoreCase("all")) {
                for (int j = 0; j < acceptedFileTypes.size(); j++) {
                    if (fileExtension.equalsIgnoreCase(acceptedFileTypes.get(j))) {
                        pictureFile = true;
                    }
                }
            } else {
                pictureFile = true;
            }

            if (pictureFile) {

                File file2 = new File(listOfFiles.get(i).getParentFile() + "\\" + prefix + "_" + (i + 1) + "." + fileExtension);

//                 Rename file (or directory)
                boolean success = file.renameTo(file2);
//
                if (!success) {
//                 File was not successfully renamed
                }
            }

        }

    }

}
