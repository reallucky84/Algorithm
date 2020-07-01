package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//연산자 끼워넣기
//https://www.acmicpc.net/problem/14888
public class BaekJoon_14888 {

    public static char[] op = new char[]{'+', '-', '*', '/'};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        String[] temp = br.readLine().split(" ");
        int i = 0;
        for (String s : temp) {
            nums[i++] = Integer.parseInt(s);
        }

        temp = br.readLine().split(" ");

        List<Character> operator = new LinkedList<>();
        for (int k = 0; k < 4; k++) {
            int num = Integer.parseInt(temp[k]);
            while (num > 0) {
                operator.add(op[k]);
                num--;
            }
        }

        int[] permu = new int[n - 1];
        for (int k = 0; k < permu.length; k++) {
            permu[k] = k;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        do {
            int cal = cal(permu, operator, nums);
            max = Math.max(max, cal);
            min = Math.min(min, cal);

//            System.out.println(Arrays.toString(permu) + " " + cal);

        } while (next_permutation(permu));
//        for(Character c: operator){
//            System.out.println(c);
//        }

        System.out.println(max);
        System.out.println(min);

    }

    public static int cal(int[] arr, List<Character> operator, int[] nums) {
        int cal = nums[0];
        int len = arr.length;
        for (int i = 0; i < len; i++) {

            char op = operator.get(arr[i]);
            if(op == '+'){
                cal += nums[i+1];
            } else if(op == '-'){
                cal -= nums[i+1];
            } else if(op == '*'){
                cal *= nums[i+1];
            } else if(op == '/'){
                cal /= nums[i+1];
            }
        }
        return cal;
    }


    public static boolean next_permutation(int[] arr) {
        int len = arr.length;
        int i = len - 1;
        while (i > 0) {
            if (arr[i - 1] < arr[i]) break;
            i--;
        }

        if (i <= 0) return false;

        int j = len - 1;
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
