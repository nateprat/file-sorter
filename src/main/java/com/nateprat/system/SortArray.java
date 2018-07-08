package com.nateprat.system;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import com.nateprat.AbstractMain;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.FileFileFilter;

public class SortArray extends AbstractMain {

    public File[] sortArray(String fileLoc, String order, ArrayList<String> fileTypes) {
        File directory = new File(fileLoc);
        // get just files, not directories
        File[] files = directory.listFiles((FileFilter) FileFileFilter.FILE);

        File[] sortedFiles = sortByFileExtension(files, fileTypes);

        if(order.equalsIgnoreCase("default")) {
            System.out.println("Default order");
            displayFiles(sortedFiles);
        }

        if(order.equalsIgnoreCase("ascending")) {
            Arrays.sort(sortedFiles, LastModifiedFileComparator.LASTMODIFIED_COMPARATOR);
            System.out.println("\nLast Modified Ascending Order (LASTMODIFIED_COMPARATOR)");
            displayFiles(sortedFiles);
        }

        if (order.equalsIgnoreCase("descending")) {
            Arrays.sort(sortedFiles, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
            System.out.println("\nLast Modified Descending Order (LASTMODIFIED_REVERSE)");
            displayFiles(sortedFiles);
        }

        return sortedFiles;

    }

    public static void displayFiles(File[] files) {
        for (File file : files) {
            System.out.printf("File: %-20s Last Modified:" + new Date(file.lastModified()) + "\n", file.getName());
        }
    }

    private File[] sortByFileExtension(File[] listOfFiles, ArrayList<String> fileTypes) {
        File[] newFiles = {};
        for (File file: listOfFiles) {
            for (String type: fileTypes) {
                if (getFileType(file).equalsIgnoreCase(type)) {
                    newFiles = addElement(newFiles, file);
                }
            }
        }
        return newFiles;
    }


    private static File[] addElement(File[] a, File e) {
        a  = Arrays.copyOf(a, a.length + 1);
        a[a.length - 1] = e;
        return a;
    }
}