package com.codecrate.textile.jruby;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String result = new RedClothTextileEngine().convertToHtml(line);
            System.out.println(result);
        }
    }
}
