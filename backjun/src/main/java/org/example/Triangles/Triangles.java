package org.example.Triangles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Triangles {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] TrianglesLine = new int[3];

        while (true) {
            String str = br.readLine();
            StringTokenizer line = new StringTokenizer(str, " ");
            TrianglesLine[0] = Integer.parseInt(line.nextToken());
            TrianglesLine[1] = Integer.parseInt(line.nextToken());
            TrianglesLine[2] = Integer.parseInt(line.nextToken());


            if(TrianglesLine[0] == 0 && TrianglesLine[1] == 0 && TrianglesLine[2] == 0) break;

            Arrays.sort(TrianglesLine);

            if(TrianglesLine[2] >= TrianglesLine[0] + TrianglesLine[1]) {
                System.out.println("Invalid");
            }else if(TrianglesLine[0] == TrianglesLine[1] && TrianglesLine[1] == TrianglesLine[2]) {
                System.out.println("Equilateral");
            }else if(TrianglesLine[0] == TrianglesLine[1] || TrianglesLine[1] == TrianglesLine[2] || TrianglesLine[0] == TrianglesLine[2]) {
                System.out.println("Isosceles");
            }else {
                System.out.println("Scalene");
            }
        }
    }
}
