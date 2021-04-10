package mohnage7;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    List<String> getFilesNamesFromDirectory(String path, String fileExtension) {
        File startDirectory = new File(path);
        File[] files = startDirectory.listFiles();
        List<String> fileNamesList = new ArrayList<>();
        return listAllFilesNames(fileNamesList, files, fileExtension);
    }


    private List<String> listAllFilesNames(List<String> fileNamesList, File[] files, String fileExtension) {
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listAllFilesNames(fileNamesList, file.listFiles(), fileExtension);
                } else {
                    String fileName = file.getName();
                    if (fileName.endsWith(fileExtension))
                        fileNamesList.add(fileName);
                }
            }
        }
        return fileNamesList;
    }
}
