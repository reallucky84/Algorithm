import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/valid-anagram/
public class LeetCode_242 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c: s.toCharArray()){
            Integer in = map.putIfAbsent(c, 1);
            if(in != null){
                map.put(c, in + 1);
            }
        }

        for(char c: t.toCharArray()){
            Integer in = map.putIfAbsent(c, 1);
            if(in != null){
                map.put(c, in - 1);
            }
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(!entry.getValue().equals(0)){
                return false;
            }
        }

        return true;
    }
}
