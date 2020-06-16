package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/2252
public class BaekJoon_2252 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        int[] inorder = new int[n + 1];

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            temp = br.readLine().split(" ");
            int key = Integer.parseInt(temp[0]);
            int next = Integer.parseInt(temp[1]);
            if (map.containsKey(key)) {
                map.get(key).add(next);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(next);
                map.put(key, list);
            }
            inorder[next]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inorder[i] == 0){
                queue.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(' ');
            sb.append(cur);

            if (map.containsKey(cur)) {
                List<Integer> list = map.get(cur);
                for (int val : list) {
                    inorder[val]--;
                    if (inorder[val] == 0) {
                        queue.offer(val);
                    }
                }
            }
        }

        sb.deleteCharAt(0);
        System.out.println(sb);
    }
}
