package collectionBigTech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ZOAC4 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer input = new StringTokenizer(br.readLine(), " ");
//        StringTokenizer input = new StringTokenizer("5 4 1 1", " ");
//        StringTokenizer st = new StringTokenizer(input, " ");

        int H = Integer.valueOf(input.nextToken());
        int W = Integer.valueOf(input.nextToken());
        int N = Integer.valueOf(input.nextToken());
        int M = Integer.valueOf(input.nextToken());

        int height = (H - 1) / (N + 1) + 1;
        int width = (W - 1) / (M + 1) + 1;

        System.out.print(height * width);

    }
 }


