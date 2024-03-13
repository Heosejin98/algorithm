package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class softeer3_1 {
    public static final int up = 0;
    public static final int down = 1;
    public static final int r = 2;
    public static final int l = 3;
    public static int findMaxMap(int current, int[][] map, boolean[][] mapHistory, int x, int y, int N)  {

        int[] dest = new int[4];
        if (y != 0 && !mapHistory[y - 1][x]) {
            dest[up] = current + map[y -1][x];
        }
        if (y != (N - 1) && !mapHistory[y + 1][x]) {
            dest[down] = current + map[y + 1][x];
        }
        if (x != 0 && !mapHistory[y][x - 1]) {
            dest[l] = current + map[y][x -1];
        }
        if (x != (N - 1) && !mapHistory[y][x + 1]) {
            dest[r] = current + map[y][x + 1];
        }
        int flag = 0;
        int max1 = 0;
        for (int i = 0; i < 4; i++) {
            if (dest[i] > max1) {
                flag = i;
                max1 = dest[i];
            }
        }

        if (flag == up) {
            mapHistory[y - 1][x] = true;
            return up;
        } else if (flag == down) {
            mapHistory[y + 1][x] = true;
            return down;
        } else if (flag == l) {
            mapHistory[y][x - 1] = true;
            return l;
        } else {
            mapHistory[y][x + 1] = true;
            return r;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stT = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stT.nextToken());
        int M = Integer.parseInt(stT.nextToken());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer stT2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stT2.nextToken());
            }
        }

        int[][] friend = new int[M][2];
        for (int i = 0; i < M; i++) {
            stT = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                friend[i][j] = Integer.parseInt(stT.nextToken()) - 1;
            }
        }

        int res[] = new int[M];
        boolean[][] mapHistory = new boolean[N][N];
        for (int i = 0; i < M; i++) {
            int y = friend[i][0];
            int x = friend[i][1];
            res[i] = map[y][x];
            mapHistory[y][x] = true;
            for (int j = 0; j < 3; j++) {
                int flag = findMaxMap(map[y][x], map, mapHistory, x, y, N);
                if (flag == up) {
                    res[i] += map[y - 1][x];
                    y = y - 1;
                } else if (flag == down) {
                    res[i] += map[y + 1][x];
                    y = y + 1;
                } else if (flag == l) {
                    res[i] += map[y][x - 1];
                    x = x - 1;
                } else {
                    res[i] += map[y][x + 1];
                    x = x + 1;
                }
            }
        }

        int total = Arrays.stream(res).sum();
        System.out.println(total);
    }
}
