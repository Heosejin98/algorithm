package org.example;

import java.io.*;
import java.util.*;

public class bk10431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int end = Integer.parseInt(br.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < end; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            String cnt = stringTokenizer.nextToken();
            Integer[] student = new Integer[20];

            for(int j = 0; j < 20; j++) {
                student[j] = Integer.parseInt(stringTokenizer.nextToken());
            }
            int res = 0;
            List<Integer> lines = new LinkedList<>();
            int max = 0;
            for(int k = 0; k < 20; k++) {

                if (lines.size() > 0 && student[k] > max) {
                    lines.add(student[k]);
                    max = student[k];
                } else if (lines.size() > 0) {
                    for (int u = 0; u < lines.size(); u++) {
                        if (lines.get(u) > student[k]) {
                            res += lines.size() - u;
                            lines.add(u, student[k]);
                            break;
                        }
                    }
                } else if (lines.size() == 0)  {
                    lines.add(student[k]);
                    max = student[k];
                }
            }
            stringBuilder.append(cnt);
            stringBuilder.append(" ");
            stringBuilder.append(res);
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }
}
