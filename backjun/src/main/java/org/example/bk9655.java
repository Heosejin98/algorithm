package org.example;

import java.io.*;

public class bk9655 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        boolean winSK = false;
        while (input > 0) {
            if (input > 3) {
                input = input - 3;
            } else {
                input = input - 1;
            }
            winSK = !winSK;
        }

        if (winSK) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
