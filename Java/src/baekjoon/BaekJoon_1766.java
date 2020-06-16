package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_1766 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        int[] inOrder = new int[n + 1];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            temp = br.readLine().split(" ");
            int key = Integer.parseInt(temp[0]);
            int val = Integer.parseInt(temp[1]);
            if (map.containsKey(key)) {
                map.get(key).add(val);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(val);
                map.put(key, list);
            }
            inOrder[val]++;
        }

        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (inOrder[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(' ').append(cur);
            if (map.containsKey(cur)) {
                for (int val : map.get(cur)) {
                    inOrder[val]--;
                    if (inOrder[val] == 0) queue.offer(val);
                }
            }
        }

        sb.deleteCharAt(0);
        System.out.println(sb);
    }
}
