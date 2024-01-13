package org.example;

import java.io.*;
import java.util.*;

public class bk1244 {
    static int[] switchList;
    public static void multple(int start,int max) {

        for (int i = start; i < switchList.length; i = i + start) {
            switchList[i] ^= 1;
        }
    }

    public static void female(int x, int max) {
        switchList[x] ^= 1;


        int count = 1;
        while ((x - count) >= 1 && (x + count) < switchList.length
                && switchList[x - count] == switchList[x + count]) {
            switchList[x - count] ^= 1;
            switchList[x + count] ^= 1;
            count++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchCnt = Integer.parseInt(br.readLine());
        switchList = new int[switchCnt + 1];

        StringTokenizer strT = new StringTokenizer(br.readLine());
        for (int i = 1; i < switchList.length; i++) {
            switchList[i] = Integer.parseInt(strT.nextToken());
        }

        int studentCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < studentCnt; i++) {
            StringTokenizer str2 = new StringTokenizer(br.readLine());
            String gender = str2.nextToken();

            if (gender.equals("1")) {
                multple(Integer.parseInt(str2.nextToken()), switchCnt);
            } else if (gender.equals("2")) {
                female(Integer.parseInt(str2.nextToken()), switchCnt);
            }
        }

        for(int i = 1; i < switchList.length; i++) {
            System.out.print(switchList[i] + " ");
            if(i % 20 == 0) {
                System.out.println();
            }
        }
    }
}
