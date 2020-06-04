package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/1182
public class BaekJoon_1182 {

    public static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int s = Integer.parseInt(temp[1]);

        int[] nums = new int[n];
        temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(temp[i]);
        }

        count(nums, 0, 0, s);

        if(s == 0){
            count--;
        }
        System.out.print(count);

    }

    public static void count(int[] nums, int currentIndex, int sum, int s) {

        if (currentIndex == nums.length) {
            if (sum == s) {
                count++;
            }
            return;
        }

        count(nums, currentIndex + 1, sum + nums[currentIndex], s);
        count(nums, currentIndex + 1, sum, s);
    }
}
