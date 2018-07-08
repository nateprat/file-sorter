package com.nateprat.system;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Date;

import com.nateprat.repository.Files;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.FileFileFilter;

public class SortArray {

    public File[] sortArray(String fileLoc, String order) {
        File directory = new File(fileLoc);
        // get just files, not directories
        File[] files = directory.listFiles((FileFilter) FileFileFilter.FILE);

        if(order.equalsIgnoreCase("default")) {
            System.out.println("Default order");
            displayFiles(files);
        }

        if(order.equalsIgnoreCase("ascending")) {
            Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_COMPARATOR);
            System.out.println("\nLast Modified Ascending Order (LASTMODIFIED_COMPARATOR)");
            displayFiles(files);
        }

        if (order.equalsIgnoreCase("descending")) {
            Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
            System.out.println("\nLast Modified Descending Order (LASTMODIFIED_REVERSE)");
            displayFiles(files);
        }

        return files;

    }

    public static void displayFiles(File[] files) {
        for (File file : files) {
            System.out.printf("File: %-20s Last Modified:" + new Date(file.lastModified()) + "\n", file.getName());
        }
    }

}