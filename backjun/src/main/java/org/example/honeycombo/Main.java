package org.example.Triangles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        if (input == 1) {
            System.out.println(1);
            return ;
        }

        int check = 1;
        int result = 1;
        while (input > check) {
            check += 6 * result;
            result++;
        }

        System.out.println(result);

    }
}
