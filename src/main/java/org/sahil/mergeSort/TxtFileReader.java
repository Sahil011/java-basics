package org.sahil.mergeSort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class TxtFileReader implements Callable<List<Integer>> {

    private File file;
    @Override
    public List<Integer> call() throws Exception {
        List<Integer> integerValues = new ArrayList<>();
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while( (line = br.readLine()) != null ){
            integerValues.add(Integer.valueOf(line));
        }
        fr.close();
        br.close();
        return integerValues;
    }

    public TxtFileReader(File inputFile){
        this.file = inputFile;
    }
}
