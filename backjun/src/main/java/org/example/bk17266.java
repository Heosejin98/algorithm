package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] x = new int[M];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            x[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int left = 0;
        int right = N;
        while (left < right) {
            int mid = (left + right) / 2;
            int current = 0;
            for (int c : x) {
                int start = c - mid;
                int end = c + mid;
                if (current < start) {
                    break;
                } else {
                    current = end;
                }
            }
            if (N <= current) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
    }
}
