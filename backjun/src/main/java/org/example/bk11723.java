package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bk11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        int[] set = new int[21];

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            int x;
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            } else {
                x = 0;
            }

            switch (cmd) {
                case "add":
                    set[x] = 1;
                    break;
                case "remove":
                    set[x] = 0;
                    break;
                case "check":
                    sb.append(set[x]).append('\n');
                    break;
                case "toggle":
                    set[x] = (set[x] == 1) ? 0 : 1;
                    break;
                case "all":
                    for (int j = 1; j <= 20; j++) {
                        set[j] = 1;
                    }
                    break;
                case "empty":
                    for (int j = 1; j <= 20; j++) {
                        set[j] = 0;
                    }
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}
