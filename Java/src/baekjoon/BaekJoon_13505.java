package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/13505
public class BaekJoon_13505 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");

        Node root = new Node();
        int[] nums = new int[temp.length];
        int maxLen = 0;
        for (String t : temp) {
            String binary = Integer.toBinaryString(Integer.parseInt(t));
            maxLen = Math.max(maxLen, binary.length());
        }

        int result = 0;
        for (String t : temp) {
            String binary = String.format("%" + maxLen + "s", Integer.toBinaryString(Integer.parseInt(t))).replace(' ', '0');
//            System.out.println(binary);
            StringBuilder sb = new StringBuilder();
            String r = root.xor(binary.toCharArray(), 0, sb);
            if(!r.equals("")){
                result = Math.max(result, Integer.parseInt(r, 2));
            }
            root.add(binary.toCharArray(), 0);
        }

        System.out.println(result);

    }

    private static class Node {

        public int val;
        public boolean isEnd;
        public Node[] children = new Node[2];

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public void add(char[] arr, int i) {
            int index = arr[i] - '0';
            if (children[index] == null) {
                children[index] = new Node(arr[i]);
            }

            if (i == arr.length - 1) {
                children[index].isEnd = true;
                return;
            }
            children[index].add(arr, i + 1);
        }

        public String xor(char[] arr, int i, StringBuilder sb) {
//            System.out.println(sb.toString());
            if (isEnd) {
                return sb.toString();
            }

            int index = arr[i] - '0';
            if (children[1 - index] != null) {
                return children[1 - index].xor(arr, i + 1, sb.append(1));

            } else if (children[index] != null) {
                return children[index].xor(arr, i + 1, sb.append(0));

            } else {
                return sb.toString();
            }
        }

    }
}
