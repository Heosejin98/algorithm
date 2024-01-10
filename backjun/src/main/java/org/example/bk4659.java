package org.example;

import java.util.*;
import java.io.*;

public class bk4659 {

    public static boolean isGather(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals("end")) {
                break;
            }
            char[] inputC = input.toCharArray();
            boolean hasGather = false;
            boolean isSame = false;
            boolean isTriple = false;
            char prev = 0;
            int cnt = 0;
            StringBuilder stb = new StringBuilder();

            for (int i = 0; i < inputC.length; i++) {
                if (inputC[i] == 'a' || inputC[i] == 'e' || inputC[i] == 'i' || inputC[i] == 'o' || inputC[i] == 'u' ) {
                    hasGather = true;
                }

                if (prev == inputC[i] && inputC[i] != 'e' && inputC[i] != 'o') {
                    isSame = true;
                    break;
                }

                if (i != 0) {
                    if (isGather(prev) && isGather(inputC[i])) {
                        cnt++;
                        if (cnt >= 2)  {
                            isTriple = true;
                            break;
                        }
                    } else if (!isGather(prev) && !isGather(inputC[i])) {
                        cnt++;
                        if (cnt >= 2) {
                            isTriple = true;
                            break;
                        }
                    } else {
                        cnt = 0;
                    }
                }

                prev = inputC[i];

            }

            if (isSame || !hasGather || isTriple) {
                stb.append("<");
                stb.append(input);
                stb.append(">");
                stb.append(" is not acceptable.");
            } else {
                stb.append("<");
                stb.append(input);
                stb.append(">");
                stb.append(" is acceptable.");
            }

            System.out.println(stb);


        }
    }
}
