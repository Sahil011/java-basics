package org.sahil;

import org.sahil.http.Client;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Client client = new Client();
        System.out.println(client.get("https://example.com").toString());
    }
}