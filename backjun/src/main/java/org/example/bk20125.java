package org.example;

import java.util.*;
import java.io.*;

public class bk20125 {

    public static class Cookie {
        private int leftArmSize;
        private int RightArmSize;
        private int ChestSize;
        private int leftLegSize;

        private int rightLegSize;

        public Cookie() {}


        public void setLeftArmSize(int leftArmSize) {
            this.leftArmSize = leftArmSize;
        }

        public void setRightArmSize(int rightArmSize) {
            RightArmSize = rightArmSize;
        }

        public void setChestSize(int chestSize) {
            ChestSize = chestSize;
        }

        public void setLeftLegSize(int leftLegSize) {
            this.leftLegSize = leftLegSize;
        }

        public void setRightLegSize(int rightLegSize) {
            this.rightLegSize = rightLegSize;
        }

        public String toString() {
            return leftArmSize
                    + " "
                    + RightArmSize
                    + " "
                    + ChestSize
                    + " "
                    + leftLegSize
                    + " "
                    + rightLegSize;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.parseInt(br.readLine());
        char[][] map = new char[max][max];
        int[] headIdx = new int[2];
        boolean findHead = false;

        for (int i = 0; i < max; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < max; j++) {
                map[i][j] = line[j];

                if (!findHead && line[j] == '*') {
                    headIdx[0] = i + 1;
                    headIdx[1] = j;
                    findHead = true;
                }
            }
        }

        //왼쪽 팔길이 측정
        Cookie cookie = new Cookie();
        int headH = headIdx[0];
        int headW = headIdx[1];
        int cnt = 0;
        for(int i = 0; i < headW; i++) {
            if (map[headH][i] == '*') {
                cnt++;
            }
        }
        cookie.setLeftArmSize(cnt);
        cnt = 0;
        for(int i = headW + 1; i < max; i++) {
            if (map[headH][i] == '*') {
                cnt++;
            } else {
                break;
            }
        }
        cookie.setRightArmSize(cnt);
        cnt = 0;
        int chestEndH = 0;
        int chestW = headW;
        for(int i = headH + 1; i < max; i++) {
            if (map[i][headW] == '*') {
                cnt++;
            } else {
                chestEndH = i;
                break;
            }
        }
        cookie.setChestSize(cnt);
        cnt = 0;
        for (int i= chestEndH ; i < max; i++) {
            if (map[i][chestW - 1] == '*') {
                cnt++;
            } else {
                break;
            }
        }
        cookie.setLeftLegSize(cnt);
        cnt = 0;
        for (int i= chestEndH; i < max; i++) {
            if (map[i][chestW + 1] == '*') {
                cnt++;
            } else {
                break;
            }
        }
        cookie.setRightLegSize(cnt);
        System.out.println((headH + 1) +  " " + (headW + 1));
        System.out.println(cookie);
    }
}