package org.sahil.mergeSort;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

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

    private static List<Integer> mergeFiles(List<File> files) throws IOException, ExecutionException, InterruptedException {
        List<Future<List<Integer>>> futureMergedVales = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for(File file : files){
            TxtFileReader fileReader = new TxtFileReader(file);
            Future<List<Integer>> integerValues = executorService.submit(fileReader);
            futureMergedVales.add(integerValues);
        }
        List<Integer> mergedValues = new ArrayList<>();
        for(Future<List<Integer>> values : futureMergedVales){
            while(!values.isDone()) {}
            mergedValues.addAll(values.get());
        }
        return mergedValues;
    }

    private static List<File> getAllFile() {
        File directoryPath = new File(getPath());
        return Arrays.asList(directoryPath.listFiles());
    }
}
