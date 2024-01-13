package org.example;

import java.util.*;
import java.io.*;

public class bk1205 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer strTk = new StringTokenizer(br.readLine());

        int max = Integer.parseInt(strTk.nextToken());

        if (max == 0) {
            System.out.println("1");
            return ;
        }
        int newScore = Integer.parseInt(strTk.nextToken());
        int maxRankSize = Integer.parseInt(strTk.nextToken());
        StringTokenizer strTk2 = new StringTokenizer(br.readLine());
        int result = -1;
        int totalEqCnt = 0;
        int eqCnt = 0;
        int preScore = -1;
        int cnt = 1;
        for (int i = 0; i < maxRankSize; i++) {
            if (max > i) {
                int score = Integer.parseInt(strTk2.nextToken());
                if (newScore > score) {
                    result = cnt + totalEqCnt;
                    break;
                }

                if (score > newScore) {
                    cnt++;
                } else if (preScore == score) {
                    eqCnt++;
                } else {
                    totalEqCnt = eqCnt;
                }
                preScore = score;
            } else {
                result = cnt + totalEqCnt;
            }
        }

        System.out.println(result);

    }

}
