package com.nateprat;

import com.nateprat.repository.GetFiles;
import com.nateprat.repository.RenameFiles;

import java.io.File;

public class Main extends AbstractMain {

    private static final RenameFiles renameFiles = new RenameFiles();
    private static final GetFiles getFiles = new GetFiles();

    public static void main(String[] args) {
        getFiles.getFiles();
        File[] listOfFiles = getFiles.getListOfFiles();
        renameFiles.renameFiles(listOfFiles);
    }
}
