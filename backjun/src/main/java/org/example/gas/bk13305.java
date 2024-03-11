package org.example.gas;

import java.util.Scanner;

public class bk13305 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);

            int N = in.nextInt();
            long[] distances = new long[N - 1];
            long[] prices = new long[N];


            for(int i = 0; i < N - 1; i++) {
                distances[i] = in.nextLong();
            }

            for(int i = 0; i < N; i++) {
                prices[i] = in.nextLong();
            }

            long sum = 0;
            long minPrcie = prices[0];

            for(int i = 0; i < N - 1; i++) {
                if(prices[i] < minPrcie) {
                    minPrcie = prices[i];
                }
                sum += (minPrcie * distances[i]);
            }
            System.out.println(sum);
        }
}
