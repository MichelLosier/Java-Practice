package com.michellosier.http;

import java.net.*;
import java.io.*;

public class HTTPrequest {
    private URL requestedURL;

    public HTTPrequest (String url) throws Exception{
        this.requestedURL = new URL(url);
    }

    public String get() throws Exception {
        HttpURLConnection connection = (HttpURLConnection)this.requestedURL.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        connection.setInstanceFollowRedirects(true);

        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String inputLine;
        StringBuffer content = new StringBuffer();

        while ((inputLine = input.readLine()) != null){
            content.append(inputLine);
        }
        input.close();
        connection.disconnect();

        return content.toString();
    }


}
