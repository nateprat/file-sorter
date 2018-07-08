package com.nateprat;

import com.nateprat.repository.Files;

public class Main extends AbstractMain {

    private static final Files files = new Files();

    public static void main(String[] args) {
        files.getFilesInDirectory();
        files.renameFiles();
    }
}
