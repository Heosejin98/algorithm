package org.example;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class bk3085 {

    public static int rowCal(char[] rowMap) {
        int res = 0;
        int max = 0;
        char prv = rowMap[0];
        for (char c : rowMap) {
            if (prv == c) {
                res++;
            } else {
                if (res > max) {
                    max = res;
                }
                res = 1;
            }
            prv = c;
        }

        return Math.max(max, res);
    }

    public static int colCal(char[][] colMap, int x) {
        int res = 0;
        int max = 0;
        char prv = colMap[0][0];
        for (int i = 0; i < colMap.length; i++) {
            if (prv == colMap[i][x]) {
                res++;
            } else {
                if (res > max) {
                    max = res;
                }
                res = 1;
            }
            prv = colMap[i][x];
        }

        return Math.max(max, res);
    }

    public static void rowSwap(char[][] map, int x, int y, int changeX) {
        char tmp = map[y][x];
        map[y][x] = map[y][changeX];
        map[y][changeX] = tmp;
    }


    public static void colSwap(char[][] map, int x, int y, int changeY) {
        char tmp = map[y][x];
        map[y][x] = map[changeY][x];
        map[changeY][x] = tmp;
    }

    public static int right(char[][] map, int x, int y, int N) {
        char[][] tmpMap = new char[map.length][];
        for (int i = 0; i < map.length; i++) {
            tmpMap[i] = map[i].clone();
        }

        if (x + 1 < N) {
            rowSwap(tmpMap, x, y, x + 1);
        }


        return Math.max(rowCal(tmpMap[y]) , colCal(tmpMap, x));
    }


    public static int left(char[][] map, int x, int y) {
        char[][] tmpMap = new char[map.length][];
        for (int i = 0; i < map.length; i++) {
            tmpMap[i] = map[i].clone();
        }

        if (x - 1 > 0) {
            rowSwap(tmpMap, x, y, x - 1);
        }

        return Math.max(rowCal(tmpMap[y]), colCal(tmpMap, x));
    }

    public static int up(char[][] map, int x, int y) {
        char[][] tmpMap = new char[map.length][];
        for (int i = 0; i < map.length; i++) {
            tmpMap[i] = map[i].clone();
        }
        if (y - 1 > 0) {
            colSwap(tmpMap, x, y, y - 1);
        }

        return Math.max(colCal(tmpMap, x), rowCal(tmpMap[y]));
    }


    public static int down(char[][] map, int x, int y, int N) {
        char[][] tmpMap = new char[map.length][];
        for (int i = 0; i < map.length; i++) {
            tmpMap[i] = map[i].clone();
        }
        if (y + 1 < N) {
            colSwap(tmpMap, x, y, y + 1);
        }

        return Math.max(colCal(tmpMap, x), rowCal(tmpMap[y]));
    }


    public static int cal(char[][] map, int x, int y, int N) {
        List<Integer> result = new ArrayList<>();
        result.add(right(map, x, y, N));
        result.add(left(map, x, y));
        result.add(up(map, x, y));
        result.add(down(map, x, y, N));

        int max = 0;
        for (int i: result) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] chars = new char[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            chars[i] = s.toCharArray();
        }

        int max = 0;
        for (int y = 0; y < N; y++) {
            boolean isStop = false;
            for (int x = 0; x < N; x++){
                int current = cal(chars, x, y, N);
                if (current > max) {
                    max = current;
                }

                if (max == N) {
                    isStop = true;
                    break;
                }
            }

            if (isStop) break;
        }

        System.out.println(max);
    }
}