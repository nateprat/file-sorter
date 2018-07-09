package com.nateprat;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.ArrayList;

public class AbstractMain {

    public static ArrayList<File> listOfFiles;

    public String getFileType(File file){
        return FilenameUtils.getExtension(file.getName());
    }


}
