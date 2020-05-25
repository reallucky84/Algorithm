import java.util.Arrays;

// https://leetcode.com/problems/product-of-array-except-self/
public class LeetCode_238 {

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(input)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return nums;
        }

        int[] result = new int[len];
        result[0] = nums[0];
        for (int i = 1; i < len; i++) {
            result[i] = result[i - 1] * nums[i];
        }

        int mul = nums[len - 1];
        result[len - 1] = result[len - 2];
        for (int i = len - 2; i > 0; i--) {
            result[i] = result[i - 1] * mul;
            mul *= nums[i];
        }
        result[0] = mul;

        return result;
    }
}
