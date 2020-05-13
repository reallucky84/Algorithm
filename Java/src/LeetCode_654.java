
// https://leetcode.com/problems/maximum-binary-tree/
public class LeetCode_654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return makeTree(nums, 0, nums.length - 1);
    }

    public TreeNode makeTree(int[] nums, int start, int end) {
        TreeNode node = new TreeNode();
        if (start <= end) {
            int mid = getMaxIndex(nums, start, end);
            node.val = nums[mid];
            node.left = makeTree(nums, start, mid - 1);
            node.right = makeTree(nums, mid + 1, end);
            return node;
        }
        return null;
    }

    public int getMaxIndex(int[] arr, int start, int end) {
        int max = Integer.MIN_VALUE;
        int result = 0;
        for (int i = start; i <= end; i++) {
            if (arr[i] > max) {
                result = i;
                max = arr[i];
            }
        }
        return result;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
