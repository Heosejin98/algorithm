package org.example;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class bk8979 {

    private static class Rank implements Comparable<Rank> {
        int key;
        int first;
        int second;
        int third;

        public Rank(int key, int first, int second, int third) {
            this.key = key;
            this.first = first;
            this.second = second;
            this.third = third;
        }

        @Override
        public int compareTo(Rank o) {
            if (this.first != o.first)
                return Integer.compare(o.first, this.first);
            if (this.second != o.second)
                return Integer.compare(o.second, this.second);
            return Integer.compare(o.third, this.third);

        }

        public int getKey() {
            return this.key;
        }



        @Override
        public int hashCode() {
            int result = first;
            result = 31 * result + second;
            result = 31 * result + third;
            return result;
        }

        @Override
        public String toString() {
            return "" + key;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(input.nextToken());
        int K = Integer.parseInt(input.nextToken());
        Rank[] ranks = new Rank[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer localInput = new StringTokenizer(br.readLine(), " ");
            int key = Integer.parseInt(localInput.nextToken());
            int first = Integer.parseInt(localInput.nextToken());
            int second = Integer.parseInt(localInput.nextToken());
            int third = Integer.parseInt(localInput.nextToken());

            Rank rank = new Rank(key, first, second, third);
            ranks[i] = rank;
        }

        Arrays.sort(ranks);

        int result = 1;
        int count = 1;
        for (int i = 0; i < N; i++) {
            if (i > 0) {
                int test =  ranks[i].compareTo(ranks[i - 1]);
                if (test == 0) {
                    count++;
                } else {
                    result += count;
                    count = 1;
                }
            }
            if (ranks[i].getKey() == K) {
                System.out.println(result);
                break;
            }
        }
    }
}
