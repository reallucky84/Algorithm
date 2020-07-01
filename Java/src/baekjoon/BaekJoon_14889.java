package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//스타트와 링크
//https://www.acmicpc.net/problem/14889
public class BaekJoon_14889 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] power = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");
            int j = 0;
            for (String s : temp) {
                power[i][j++] = Integer.parseInt(s);
            }
        }

        int[] permu = new int[n];
        for (int i = n - 1; i >= n / 2; i--) {
            permu[i] = 1;
        }

        int result = Integer.MAX_VALUE;

        do {
            result = Math.min(result, cal(permu, power));
        }
        while (next_permutation(permu));

        System.out.println(result);

    }

    public static int cal(int[] permu, int[][] power) {
        int n = permu.length / 2;
        int[] teamA = new int[n];
        int[] teamB = new int[n];

        int i = 0;
        int j = 0;
        int k = 0;
        for (int p : permu) {
            if (p == 0) {
                teamA[i++] = k++;
            } else {
                teamB[j++] = k++;
            }
        }

        int powerA = 0;
        int powerB = 0;

        for (int l = 0; l < n; l++) {
            for (int m = l + 1; m < n; m++) {
                powerA += power[teamA[l]][teamA[m]] + power[teamA[m]][teamA[l]];
                powerB += power[teamB[l]][teamB[m]] + power[teamB[m]][teamB[l]];
            }
        }

        return Math.abs(powerA - powerB);
    }

    public static boolean next_permutation(int[] arr) {
        int len = arr.length - 1;
        int i = len;
        while (i > 0) {
            if (arr[i - 1] < arr[i]) break;
            i--;
        }

        if (i <= 0) return false;

        int j = len;
        while (j >= i) {
            if (arr[i - 1] < arr[j]) break;
            j--;
        }

        swap(i - 1, j, arr);

        len--;
        while (i < len) {
            swap(i, len, arr);
            i++;
            len--;
        }
        return true;
    }

    public static void swap(int x, int y, int[] arr) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
