package org.sahil.http;

import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class Client {

    OkHttpClient okHttpClient;

    public Client(){
        okHttpClient = new OkHttpClient();
    }
    public String get(String url){
        Request request = new Request.Builder().url(url).build();
        try{
            return okHttpClient.newCall(request).execute().body().toString();
        }catch(IOException ioe){
            System.out.println("Ex : "+ioe.getMessage());
            return null;
        }
    }


}
