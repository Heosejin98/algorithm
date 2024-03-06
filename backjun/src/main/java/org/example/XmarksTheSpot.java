package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class XmarksTheSpot {

    public static int findIndex(char[] cs) {
        int i = 0;
        for(char c : cs) {
            if (c == 'x' || c == 'X') {
                return i;
            }
            i++;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.parseInt(br.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < max; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine(), " ");
            char[] S = input.nextToken().toCharArray();
            int idx = findIndex(S);
            char[] T = input.nextToken().toCharArray();

            stringBuilder.append(T[idx]);
        }

        System.out.print(stringBuilder.toString().toUpperCase());
    }
}
