package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/11052
public class BaekJoon_11052 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] p = br.readLine().split(" ");

        int[] d = new int[n + 1];
        d[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= i; k++) {
                d[i] = Math.max(d[i], d[i - k] + Integer.parseInt(p[k - 1]));
            }
        }
        System.out.println(d[n]);

    }
}