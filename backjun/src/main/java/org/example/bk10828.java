package org.example;

import java.util.*;
import java.io.*;

public class bk10828 {

    public static class Stackasd {
        int[] stack;
        int size;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        public Stackasd() {
            stack = new  int[10000];
            size = 0;
        }

        public void push(int i) {
            stack[size] = i;
            size++;
        }

        public void pop() throws IOException {
            if (size == 0) {
                bw.write("-1\n");
                bw.flush();
            } else {
                bw.write(stack[size - 1] + "\n");
                bw.flush();
//                System.out.println(stack[size - 1]);
                stack[size - 1] = 0;
                size--;
            }
        }

        public void size() throws IOException {
            bw.write(size + "\n");
            bw.flush();
//            System.out.println(size);
        }

        public void empty() throws IOException {
            if (size == 0) {
                bw.write("1\n");
                bw.flush();
//                System.out.println(1);
            } else {
                bw.write("0\n");
                bw.flush();
//                System.out.println(0);
            }
        }

        public void top() throws IOException {
            if (size != 0) {
                bw.write(stack[size - 1] + "\n");
                bw.flush();
//                System.out.println(stack[size - 1]);
            } else {
                bw.write("-1\n");
                bw.flush();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        Stackasd stackasd = new Stackasd();
        for (int i = 0; i < cnt; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine(), " ");
            String command = str.nextToken();

            if (command.equals("push")) {
                stackasd.push(Integer.parseInt(str.nextToken()));
            } else if (command.equals("pop")) {
                stackasd.pop();
            } else if (command.equals("size")) {
                stackasd.size();
            } else if (command.equals("empty")) {
                stackasd.empty();
            } else if (command.equals("top")) {
                stackasd.top();
            }

        }
    }
}
