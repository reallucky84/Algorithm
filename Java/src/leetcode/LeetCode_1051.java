package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/height-checker/
public class LeetCode_1051 {

    public int heightChecker(int[] heights) {
        int result = 0;
        int len = heights.length;

        int[] original = new int[len];
        for(int i = 0; i < len; i++){
            original[i] = heights[i];
        }

        Arrays.sort(original);

        for(int i = 0; i < len; i++){
            if(original[i] != heights[i]){
                result++;
            }
        }

        return result;

    }
}
