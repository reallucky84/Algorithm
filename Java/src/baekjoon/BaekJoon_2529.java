package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//부등호
//https://www.acmicpc.net/problem/2529
public class BaekJoon_2529 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String[] symbol = br.readLine().split(" ");

        int[] small = new int[k + 1];
        int[] big = new int[k + 1];

        for (int i = 0; i < k + 1; i++) {
            small[i] = i;
            big[i] = 9 - i;
        }

        do {
//            System.out.println(Arrays.toString(small));
            if (check(small, symbol)) {
                break;
            }
        } while (nextPremutation(small));


        do {
//            System.out.println(Arrays.toString(big));
            if (check(big, symbol)) {
                break;
            }
        } while (prevPremutation(big));

        printResult(big);
        printResult(small);
    }

    public static void printResult(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static boolean check(int[] arr, String[] symbol) {
        int n = symbol.length;
        for (int i = 0; i < n; i++) {
//            System.out.println(arr[i] + symbol[i] + arr[i + 1]);
            if ((symbol[i].equals("<") && arr[i + 1] < arr[i]) || (symbol[i].equals(">") && arr[i] < arr[i + 1])) {
                return false;
            }
        }
        return true;
    }

    public static boolean nextPremutation(int[] arr) {
        int i = -1;
        int j = -1;
        int len = arr.length;
        for (int k = len - 1; k > 0; k--) {
            if (arr[k - 1] < arr[k]) {
                i = k;
                break;
            }
        }

        if (i == -1) {
            return false;
        }

        for (int k = len - 1; k >= i; k--) {
            if (arr[i - 1] < arr[k]) {
                j = k;
                break;
            }
        }
        swap(arr, i - 1, j);
        len--;
        while (i < len) {
            swap(arr, i, len);
            i++;
            len--;
        }
        return true;
    }

    public static boolean prevPremutation(int[] arr) {
        int i = -1;
        int j = -1;
        int len = arr.length;
        for (int k = len - 1; k > 0; k--) {
            if (arr[k - 1] > arr[k]) {
                i = k;
                break;
            }
        }

        if (i == -1) {
            return false;
        }

        for (int k = len - 1; k >= i; k--) {
            if (arr[i - 1] > arr[k]) {
                j = k;
                break;
            }
        }
        swap(arr, i - 1, j);
        len--;
        while (i < len) {
            swap(arr, i, len);
            i++;
            len--;
        }
        return true;
    }

    public static void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

}
