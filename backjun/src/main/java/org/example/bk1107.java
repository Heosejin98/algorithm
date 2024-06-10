package org.example;

import java.util.*;
import java.io.*;

public class bk1107 {
    public static boolean isButtonWorking(int N, Set<Integer> brokenButtons) {
        if (N == 0) {
            return !brokenButtons.contains(0);
        }
        while (N > 0) {
            if (brokenButtons.contains(N % 10)) {
                return false;
            }
            N /= 10;
        }
        return true;
    }

    public static int buttonPressCount(int N) {
        if (N == 0) {
            return 1;
        }
        int count = 0;
        while (N > 0) {
            N /= 10;
            count++;
        }
        return count;
    }

    public static int findClosestValidChannel(int targetChannel, Set<Integer> brokenButtons) {
        int lower = targetChannel, upper = targetChannel;
        while (lower >= 0 || upper <= 1000000) {
            if (lower >= 0 && isButtonWorking(lower, brokenButtons)) {
                return lower;
            }
            if (upper <= 1000000 && isButtonWorking(upper, brokenButtons)) {
                return upper;
            }
            lower--;
            upper++;
        }
        return 100; // Fallback, should never reach here
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int targetChannel = Integer.parseInt(br.readLine());
        if (targetChannel == 100) {
            System.out.println(0);
            return;
        }

        int brokenButtonCount = Integer.parseInt(br.readLine());
        Set<Integer> brokenButtons = new HashSet<>();
        if (brokenButtonCount > 0) {
            String[] brokenButtonStrings = br.readLine().split(" ");
            for (String button : brokenButtonStrings) {
                brokenButtons.add(Integer.parseInt(button));
            }
        }

        int minPressCount = Math.abs(targetChannel - 100); // From starting channel 100
        int closestValidChannel = findClosestValidChannel(targetChannel, brokenButtons);
        int buttonPressCountToClosest = buttonPressCount(closestValidChannel);
        int totalPressCount = buttonPressCountToClosest + Math.abs(targetChannel - closestValidChannel);
        minPressCount = Math.min(minPressCount, totalPressCount);

        System.out.println(minPressCount);
    }
}
