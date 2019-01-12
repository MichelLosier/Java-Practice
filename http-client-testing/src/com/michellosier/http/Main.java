package com.michellosier.http;

public class Main {

    public static void main(String[] args) {
        // write your code here
        try {
            HTTPrequest request = new HTTPrequest("https://google.com");
            String content = request.get();
            System.out.println(content);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
