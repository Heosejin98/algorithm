package org.example;

import java.nio.Buffer;
import java.util.*;
import java.io.*;

public class bk7568 {
    public static class human  {
        public int h;
        public int w;
        public int res;

        public human(int h, int w) {
            this.h = h;
            this.w = w;
        }

        public boolean isBig(human o) {
            return this.h < o.h && this.w < o.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        human[] humans = new human[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int w = Integer.parseInt(st.nextToken());
            int h  = Integer.parseInt(st.nextToken());

            humans[i] = new human(h, w);
        }

        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < humans.length; i++) {
            int rank = 1;
            for (int j = 0; j < humans.length; j++) {
                if (humans[i].isBig(humans[j])) {
                    rank++;
                }
            }
            stb.append(rank);
            if (i < humans.length - 1) {
                stb.append(" ");
            }
        }

        System.out.println(stb);
    }
}
