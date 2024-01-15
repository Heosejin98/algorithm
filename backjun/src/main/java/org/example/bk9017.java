package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class bk9017 {

    public static class Ranking implements Comparable<Ranking> {
        int size;
        int score;

        int five;

        public Ranking(int score) {
            this.size = 1;
            this.score = score;
            this.five = 0;
        }

        public void add(int score) {
            if (size >= 4) {
                size++;
                if (size == 5) {
                    five = score;
                }
                return;
            }

            this.size++;
            this.score += score;

        }

        @Override
        public int compareTo(Ranking o) {
            if (this.score != o.score)
                return Integer.compare(this.score, o.score);

            return Integer.compare(this.five, o.five);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.parseInt(bufferedReader.readLine());
        List<String> res = new ArrayList<>();

        for (int i = 0; i < max; i++) {
            int N = Integer.parseInt(bufferedReader.readLine());
            StringTokenizer strTk = new StringTokenizer(bufferedReader.readLine());
            Map<String, Integer> map = new HashMap<>();
            List<String> ranks = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                String token = strTk.nextToken();;
                ranks.add(token);
                if (map.containsKey(token)) {
                    map.put(token, map.get(token) + 1);
                } else {
                    map.put(token, 1);
                }
            }

            int skip = 0;
            Map<String, Ranking> rankingMap = new HashMap<>();
            for (int k = 0;  k < ranks.size(); k++) {
                if (map.get(ranks.get(k)) >= 6) {
                    int score = (k + 1) - skip;
                    if (rankingMap.containsKey(ranks.get(k))) {
                        rankingMap.get(ranks.get(k)).add(score);
                    } else {
                        rankingMap.put(ranks.get(k), new Ranking(score));
                    }
                } else {
                    skip++;
                }
            }

            // rankingMap을 score 및 five에 대해 정렬
            List<Entry<String, Ranking>> sortedList = rankingMap.entrySet().stream()
                    .sorted((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()))
                    .collect(Collectors.toList());

            // 정렬된 리스트에서 첫 번째 항목 가져와서 res에 추가
            res.add(sortedList.get(0).getKey());
        }

        for (String i : res) {
            System.out.print(i + " ");
        }
    }

}