package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//카드구매하기2
//https://www.acmicpc.net/problem/16194
public class BaekJoon_16194 {

    public static void main(String... args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] cards = br.readLine().split(" ");

        int[] d = new int[n + 1];
        Arrays.fill(d, -1);
        d[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= i; k++) {
                int cur = d[i - k] + Integer.parseInt(cards[k - 1]);
                if (d[i] == -1 || cur < d[i]) {
                    d[i] = cur;
                }
            }
        }
        System.out.println(d[n]);
    }

}
