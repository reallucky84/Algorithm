import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://www.acmicpc.net/problem/15658
public class BaekJoon_15658 {

    public static int n = 0;

    public static int min = 999999999;
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        String[] temp = br.readLine().split(" ");
        int[] nums = new int[n];
        int k = 0;
        for (String s : temp) {
            nums[k] = Integer.parseInt(s);
            k++;
        }

        temp = br.readLine().split(" ");
        int plus = 0;
        int minus = 0;
        int mul = 0;
        int div = 0;
        k = 0;
        for (String s : temp) {
            switch (k) {
                case 0:
                    plus = Integer.parseInt(s);
                    break;
                case 1:
                    minus = Integer.parseInt(s);
                    break;
                case 2:
                    mul = Integer.parseInt(s);
                    break;
                case 3:
                    div = Integer.parseInt(s);
                    break;
            }
            k++;
        }

        find(1, nums[0], plus, minus, mul, div, nums);

        System.out.println(max);
        System.out.println(min);
    }

    public static void find(int index, int cal, int plus, int minus, int mul, int div, int[] nums) {
        if (index == n) {
            max = Math.max(max, cal);
            min = Math.min(min, cal);
            return;
        }

        if (plus > 0) {
            find(index + 1, operation('+', nums, cal, index), plus - 1, minus, mul, div, nums);
        }

        if (minus > 0) {
            find(index + 1, operation('-', nums, cal, index), plus, minus - 1, mul, div, nums);
        }

        if (mul > 0) {
            find(index + 1, operation('*', nums, cal, index), plus, minus, mul - 1, div, nums);
        }

        if (div > 0) {
            find(index + 1, operation('/', nums, cal, index), plus, minus, mul, div - 1, nums);
        }

    }

    public static int operation(char op, int[] nums, int cal, int index) {
        switch (op) {
            case '+':
                return cal + nums[index];
            case '-':
                return cal - nums[index];
            case '*':
                return cal * nums[index];
            case '/':
                return cal / nums[index];
            default:
                return cal;
        }
    }

}
