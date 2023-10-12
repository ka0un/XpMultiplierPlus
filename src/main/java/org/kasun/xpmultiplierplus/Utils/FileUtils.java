package org.kasun.xpmultiplierplus.Utils;

import org.kasun.xpmultiplierplus.XpMultiplierPlus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUtils {
    //methode for copy file from plugin to specified location
    public static void copyResourceFileToFolder(String resourceName, String destinationFolderPath) {
        try {
            // Get the input stream for the resource file
            InputStream inputStream = XpMultiplierPlus.class.getResourceAsStream("/" + resourceName);

            // Check if the resource exists
            if (inputStream == null) {
                System.err.println("Resource not found: " + resourceName);
                return;
            }

            // Create the destination folder if it doesn't exist
            Files.createDirectories(Paths.get(destinationFolderPath));

            // Create the destination file path
            Path destinationFilePath = Paths.get(destinationFolderPath, resourceName);

            // Copy the file from the input stream to the destination file
            Files.copy(inputStream, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to copy the file: " + e.getMessage());
        }
    }

}
