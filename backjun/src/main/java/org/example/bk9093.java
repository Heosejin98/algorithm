package org.example;


import java.util.*;
import java.io.*;

public class bk9093 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer strT = new StringTokenizer(br.readLine());
            int tokenSize = strT.countTokens();
            for (int j = 0; j < tokenSize; j++) {
                char[] chars = strT.nextToken().toCharArray();
                char[] temp = new char[chars.length];
                int tempMax = chars.length - 1;
                for (int k = 0;  k < chars.length; k++) {
                    temp[k] = chars[tempMax--];
                }
                stb.append(temp).append(" ");
            }
            stb.append("\n");
        }


        System.out.println(stb);


    }

}
