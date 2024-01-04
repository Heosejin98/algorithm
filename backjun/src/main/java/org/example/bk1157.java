package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class bk1157 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().toUpperCase();
        char[] str = input.toCharArray();
        Map<Character, Integer> cnt = new HashMap<>();

        for (Character c : str) {
            if (cnt.containsKey(c)) {
                cnt.put(c, cnt.get(c) + 1);
            } else {
                cnt.put(c, 1);
            }
        }
        int max = 0;
        String result = "";
        boolean isDuplicated = false;

        for (Character key : cnt.keySet()) {
            int current = cnt.get(key);

            if (current > max) {
                max = current;
                result = String.valueOf(key);
                isDuplicated = false;
            } else if (max == current) {
                isDuplicated = true;
            }
        }

        if (isDuplicated) {
            System.out.println("?");
        } else {
            System.out.println(result);
        }
    }
}