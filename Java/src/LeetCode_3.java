import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LeetCode_3 {

    public static void main(String[] args) {
        String input = "abcabcabc";
        System.out.println(lengthOfLongestSubstring(input));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int result = 0;
        int len = s.length();
        if (len == 1) return 1;
        if (len > 1) {
            int start = 0;
            map.put(s.charAt(0), 0);
            for (int i = 1; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.containsKey(c)) {
                    if (map.get(c) >= start) {
                        start = map.get(c) + 1;
                    }
                }
                result = Math.max(result, i - start + 1);
                map.put(c, i);
            }
        }

        // System.out.println(result);
        return result;
    }
}
