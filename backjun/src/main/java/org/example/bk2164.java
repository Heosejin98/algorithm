package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bk2164 {


    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> card = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            card.add(i);
        }

        while (!card.isEmpty()) {
            if (card.size() == 1) {
                break;
            }

            card.poll();
            Integer next = card.poll();
            card.add(next);
        }

        System.out.println(card.poll());


    }
}
