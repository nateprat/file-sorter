package com.nateprat.repository;

import com.nateprat.AbstractMain;
import org.apache.commons.io.FilenameUtils;

import java.io.File;

public class RenameFiles extends AbstractMain {

    private static String[] acceptedFileTypes = {"jpg", "png", "gif"};

    public void renameFiles(File[] listOfFiles) {
        boolean pictureFile = false;
        for (int i = 0; i < listOfFiles.length; i++) {
            // File (or directory) with old name
            File file = new File(listOfFiles[i].getPath());

            // File (or directory) with new name
            String fileExtension = getFileType(file);

            for (int j = 0; j < acceptedFileTypes.length; j++) {
                if (fileExtension.equalsIgnoreCase(acceptedFileTypes[j])) {
                    pictureFile = true;
                }
            }

            if (pictureFile) {


                File file2 = new File(listOfFiles[i].getParentFile() + "\\steam_pic_" + (i + 1) + "." + fileExtension);

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

