package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//문자열 집합
//https://www.acmicpc.net/problem/14425
public class BeakJoon_14425 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().split(" ");
        int n = Integer.parseInt(temp[0]);
        int m = Integer.parseInt(temp[1]);

        Node root = new Node();


        String[] nString = new String[n];
        for (int i = 0; i < n; i++) {
            nString[i] = br.readLine();
            root.add(nString[i].toCharArray(), 0);
//            System.out.println();
        }


        int result = 0;

        String[] mString = new String[m];
        for (int i = 0; i < m; i++) {
            mString[i] = br.readLine();
            if (root.search(mString[i].toCharArray(), 0)) {
                result++;
            }
//            System.out.println(root.search(mString[i]));
        }

        System.out.println(result);

    }

    private static class Node {
        public boolean isWord;
        public char val;
        public Node[] children = new Node[26];

        public Node() {
        }

        public Node(char val) {
            this.val = val;
        }

        public void add(char[] s, int i) {
            int idx = s[i] - 'a';
            if (children[idx] == null) {
                children[idx] = new Node(s[i]);
            }
            if (i == s.length - 1) {
                children[idx].isWord = true;
                return;
            }
            children[idx].add(s, i + 1);
        }

        public boolean search(char[] s, int i) {
            int idx = s[i] - 'a';
            if (children[idx] == null) {
                return false;
            } else {
                if (i == s.length - 1) {
                    return children[idx].isWord;
                } else {
                    return children[idx].search(s, i + 1);
                }
            }
        }

    }
}
