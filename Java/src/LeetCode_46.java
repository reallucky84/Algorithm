import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/permutations/submissions/
public class LeetCode_46 {

    public static void main(String[] args) {
        int[] input1 = new int[]{1, 2, 3};

        int[] input2 = new int[]{0,-1,1};
        permute(input1);

        permute(input2);
    }

    public static List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> returnList = new ArrayList<>();
        List<Integer> permuList = new ArrayList<>();

        do{
            System.out.println(Arrays.toString(nums));
            for (int i : nums) {
                permuList.add(i);
            }
            returnList.add(permuList);
            permuList.clear();
        } while (next_permutation(nums));

        return returnList;
    }

    public static boolean next_permutation(int[] arr){
        int len = arr.length;
        int i = len - 1;
        while(i > 0){
            if(arr[i-1] < arr[i]) break;
            i--;
        }

        if(i <= 0) return false;

        int j = len - 1;
        while(j >= i){
            if(arr[i-1] < arr[j]) break;
            j--;
        }

        swap(arr, i-1, j);

        len--;
        while(i < len){
            swap(arr, i, len);
            i++;
            len--;
        }
        return true;
    }

    public static void swap(int[] arr, int x, int y){
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
