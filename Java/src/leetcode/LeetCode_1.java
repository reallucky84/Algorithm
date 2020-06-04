package leetcode;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
public class LeetCode_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        int i = 0;
        for (int n : nums) {

            if (map.containsKey(target - n) && map.get(target - n) != i) {
                result[0] = map.get(target - n);
                result[1] = i;
                break;
            }
            map.put(n, i);
            i++;
        }

        return result;
    }
}


