package org.example;

import java.util.*;
import java.io.*;
public class bk25757 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(br.readLine(), " ");
        int max = Integer.parseInt(input.nextToken());
        String game = input.nextToken();
        Set<String> nameSet = new HashSet<>();

        for (int i = 0; i < max; i++) {
            nameSet.add(br.readLine());
        }
        int gameMax = 0;
        if (game.equals("Y")) {
            gameMax = nameSet.size();
        } else if (game.equals("F")) {
            gameMax = nameSet.size() / 2;
        } else if (game.equals("O")) {
            gameMax = nameSet.size() / 3;
        }

        System.out.println(gameMax);
    }
}