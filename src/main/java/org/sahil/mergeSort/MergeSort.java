package org.sahil.mergeSort;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.io.FileUtils.writeLines;

public class MergeSort {

    private static String getPath(){
        return "./Input";
    }

    public static void mergeSortFiles() throws Exception {
        List<File> files = getAllFile();
        List<Integer> mergedData = mergeFiles(files);
        Collections.sort(mergedData);
        genrateOutFile(mergedData);

    }

    private static void genrateOutFile(List<Integer> mergedData) throws Exception {
        File file = new File("./Output/MergedSorted.txt");
        writeLines(file, mergedData, false);
    }

    private static List<Integer> mergeFiles(List<File> files) throws IOException {
//        Files.walk(Paths.get("src/main/resources/")).parallel().(Path::normalize).
//                collect(Collectors.toList());

        List<Integer> mergedVales = new ArrayList<>();
        for(File file : files){
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while( (line = br.readLine()) != null ){
                mergedVales.add(Integer.valueOf(line));
            }
            fr.close();
            br.close();
        }
        return mergedVales;
    }

    private static List<File> getAllFile() {
        File directoryPath = new File(getPath());
        return Arrays.asList(directoryPath.listFiles());
    }
}
