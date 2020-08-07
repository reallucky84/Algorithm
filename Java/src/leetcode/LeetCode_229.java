package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/majority-element-ii/
public class LeetCode_229 {
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        int d = len / 3;
        // System.out.println(len + " " + d);
        Arrays.sort(nums);

        List<Integer> result = new ArrayList<>();

        int count = 0;

        for(int i = 0; i < len; i++){
            count++;
            if(i == len-1 || nums[i] != nums[i+1]){
                if(count > d){
                    result.add(nums[i]);
                }
                count = 0;
            }
        }
        return result;
    }
}
