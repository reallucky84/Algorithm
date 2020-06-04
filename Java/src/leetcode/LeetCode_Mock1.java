package leetcode;

import java.util.ArrayList;
import java.util.List;


public class LeetCode_Mock1 {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        int[] permutation = new int[len];
        for(int i = 0; i < len; i++){
            permutation[i] = i;
        }
        List<List<Integer>> list = new ArrayList<>();

        // System.out.println(Arrays.toString(permutation));

        list.add(makeList(permutation, nums));
        while(next_permutation(permutation)){
            // System.out.println(Arrays.toString(permutation));
            list.add(makeList(permutation, nums));
        }
        return list;
    }

    public boolean next_permutation(int[] arr){
        int i = -1;
        int j = -1;
        int len = arr.length;
        for(int k = len -1; k > 0; k--){
            if(arr[k-1] < arr[k]){
                i = k;
                break;
            }
        }

        if(i == -1){
            return false;
        }

        for(int k = len -1; k >= i; k--){
            if(arr[i-1] < arr[k]){
                j = k;
                break;
            }
        }

        swap(i-1, j, arr);

        len--;
        while(i < len){
            swap(i++, len--, arr);
        }
        return true;
    }

    public void swap(int x, int y, int[] arr){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public List<Integer> makeList(int[] permutation, int[] nums){
        List<Integer> list = new ArrayList<>();
        for(int p: permutation){
            list.add(nums[p]);
        }
        return list;
    }
}
