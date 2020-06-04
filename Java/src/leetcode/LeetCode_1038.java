package leetcode;

import java.util.Stack;

// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
public class LeetCode_1038 {
    public TreeNode bstToGst(TreeNode root) {

        TreeNode current = root;
        int sum = 0;

        Stack<TreeNode> stack = new Stack<>();

        while(current != null || !stack.isEmpty()){

            while(current != null){
                stack.push(current);
                current = current.right;
            }

            current = stack.pop();
            current.val += sum;
            sum = current.val;

            current = current.left;
        }

        return root;
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
