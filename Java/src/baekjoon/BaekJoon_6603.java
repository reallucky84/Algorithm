package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

// https://www.acmicpc.net/problem/6603
public class BaekJoon_6603 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] temp = br.readLine().split(" ");
            if (temp[0].equals("0")) break;

            int n = Integer.parseInt(temp[0]);
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(temp[i + 1]);
            }

            List<Integer> list = new LinkedList<>();
            play(nums, 0, 0, list);
            System.out.println();
        }


    }

    public static void play(int[] nums, int currentIndex, int selected, List<Integer> list) {
        if (selected == 6) {
            printList(list);
            return;
        }

        if (currentIndex == nums.length) return;

        list.add(nums[currentIndex]);
        play(nums, currentIndex + 1, selected + 1, list);
        list.remove(list.size() - 1);
        play(nums, currentIndex + 1, selected, list);

    }

    public static void printList(List<Integer> list) {
        System.out.print(list.get(0));
        int size = list.size();
        for (int i = 1; i < size; i++) {
            System.out.print(' ');
            System.out.print(list.get(i));
        }
        System.out.println();
    }
}
