package org.sahil;

import org.sahil.http.Client;
import org.sahil.mergeSort.MergeSort;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
        MergeSort.mergeSortFiles();
        System.out.println("done >> >>");
       // Client client = new Client();
        //System.out.println(client.get("https://example.com"));
    }
}