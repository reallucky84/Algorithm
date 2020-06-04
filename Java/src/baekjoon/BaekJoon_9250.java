package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/9250
public class BaekJoon_9250 {

    private static class Trie {

        public Node root;
        public List<String> wordList;

        public Trie() {
            root = new Node();
            wordList = new ArrayList<>();
        }

        public void insertString(String s) {
            wordList.add(s);
            int wordIdx = wordList.size() - 1;
            insert(root, s.toCharArray(), 0, wordIdx);
        }

        private void insert(Node node, char[] s, int index, int wordIdx) {
            int len = s.length;
            if (index == len) {
                node.isWord = wordIdx;
//                System.out.println();
                return;
            }

            int charIdx = s[index] - 'a';
//            System.out.print(s[index]);
            if (node.children[charIdx] == null) {
                node.children[charIdx] = new Node();
//                System.out.print('-');
            }
            insert(node.children[charIdx], s, index + 1, wordIdx);
        }

        public void makeFail() {

            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                Node cur = queue.poll();
                int len = cur.children.length;
                for (int i = 0; i < len; i++) {
                    Node child = cur.children[i];
                    if (child == null) continue;
                    if (cur == root) {
                        child.fail = root;
                    } else {
                        Node p = cur.fail;
                        while(p != root && p.children[i] == null){
                            p = p.fail;
                        }
                        if(p.children[i] != null){
                            p = p.children[i];
                        }
                        child.fail = p;

//                        while (child.fail == null) {
//                            if (p == root && p.children[i] == null) {
//                                child.fail = root;
//                            } else if (p.children[i] != null) {
//                                child.fail = p.children[i];
//                            }
//                            p = p.fail;
//                        }
                    }
                    queue.offer(child);
                }
            }

        }

        public boolean search(char[] s) {
            Node cur = root;
            for (char c : s) {
                int charIdx = c - 'a';
                System.out.print(c);
                while (cur != root && cur.children[charIdx] == null) {
                    cur = cur.fail;
                }

                if (cur.children[charIdx] != null) {
                    cur = cur.children[charIdx];
                }

//                if (cur.children[charIdx] != null) {
//                    cur = cur.children[charIdx];
//                    System.out.println(" move");
//                } else {
//                    System.out.println(" fail");
//                    if(cur.fail != null) cur = cur.fail;
//                }
                if (cur.isWord > -1) return true;
            }
            return false;
        }

        private static class Node {
            public Node[] children = new Node[26];
            public int isWord = -1;
            public Node fail;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Trie trie = new Trie();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            trie.insertString(br.readLine());
        }

        trie.makeFail();

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            if (trie.search(br.readLine().toCharArray())) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
