package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//접두사 찾기
//https://www.acmicpc.net/problem/14426
public class BaekJoon_14426 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int m = Integer.parseInt(temp[0]);
        int n = Integer.parseInt(temp[1]);

        Node root = new Node();
        for (int i = 0; i < m; i++) {
            root.add(br.readLine().toCharArray(), 0);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (root.search(br.readLine().toCharArray(), 0)) result++;
        }

        System.out.println(result);
    }

    private static class Node {
        public char val;
        public boolean isWord;
        public Node[] children = new Node[26];

        public Node() {
        }

        public Node(char val) {
            this.val = val;
        }

        public void add(char[] val, int i) {
            int index = val[i] - 'a';
            if (children[index] == null) {
                children[index] = new Node(val[i]);
            }
            if (i == val.length - 1) {
                children[index].isWord = true;
                return;
            }
            children[index].add(val, i + 1);
        }

        public boolean search(char[] val, int i) {
            int index = val[i] - 'a';
            if (children[index] == null) {
                return false;
            }
            if (i == val.length - 1) {
                return true;
            }
            return children[index].search(val, i + 1);
        }

    }
}
