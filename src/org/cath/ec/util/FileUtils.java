package org.cath.ec.util;

import java.io.File;

public class FileUtils {

    /**
     * Get extension of a file which included period ('.').
     * 
     * @param filePath
     * @return
     */
    public static String getFileExtension(String filePath) {
        if (filePath == null) {
            return null;
        }

        return filePath.substring(filePath.lastIndexOf('.')).toLowerCase();
    }

    public static String moveFile(String fileSrc, String directoryDest) {
        // File (or directory) to be moved
        File file = new File(fileSrc);

        // Destination directory
        File dir = new File(directoryDest);

        File dest = new File(dir, file.getName());
        // Move file to new directory
        if (!file.renameTo(dest)) {
            return null;
        }

        return dest.getAbsolutePath();
    }

    public static boolean checkFileExist(String filePath) {
        File check = new File(filePath);
        return check.exists();
    }
}
