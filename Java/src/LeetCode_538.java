import java.util.Stack;

// https://leetcode.com/problems/convert-bst-to-greater-tree/submissions/
public class LeetCode_538 {

    public TreeNode convertBST(TreeNode root) {
        TreeNode current = root;
        int sum = 0;

        Stack<TreeNode> stack = new Stack<>();

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
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
