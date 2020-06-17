package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/1790
public class BaekJoon_1790 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int answer = -1;
        if (calc(n) < k) {
            System.out.print(answer);
            return;
        }

        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = (left + right) / 2;
            long cal = calc(mid);
            if (cal < k) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }

        long len = calc(answer);
        String s = String.valueOf(answer);
        long index = (long) s.length() - (len - (long) k) - 1;
        System.out.println(s.charAt((int) index));

    }

    public static long calc(int n) {
        long cal = 0;
        for (int i = 1, len = 1; i <= n; i *= 10, len++) {
            int end = i * 10 - 1;
            if (n < end) {
                end = n;
            }
            cal += (end - i + 1) * len;
        }
        return cal;
    }
}
