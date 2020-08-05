package leetcode;

//https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
public class LeetCode_1160 {
    public int countCharacters(String[] words, String chars) {
        int[] a = new int[26];
        for (char c : chars.toCharArray()) {
            a[c - 'a']++;
        }

        int answer = 0;

        outloop:
        for (String s : words) {
            int[] w = a.clone();
            for (char c : s.toCharArray()) {
                int index = c - 'a';
                w[index]--;
                if (w[index] < 0) {
                    continue outloop;
                }
            }
            answer += s.length();
        }
        return answer;
    }
}
