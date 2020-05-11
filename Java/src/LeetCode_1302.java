
// https://leetcode.com/problems/deepest-leaves-sum/
public class LeetCode_1302 {

    int maxDepth;
    int result;

    public static void main(String[] args){

    }

    public int deepestLeavesSum(TreeNode root) {
        dfs1(root, 0);
        dfs2(root, 0);
        return result;
    }

    public void dfs1(TreeNode tree, int depth) {

        if (tree.left != null) {
            dfs1(tree.left, depth + 1);
        }

        if (tree.right != null) {
            dfs1(tree.right, depth + 1);
        }

        if (tree.left == null && tree.right == null) {
            maxDepth = Math.max(maxDepth, depth);
        }
    }

    public void dfs2(TreeNode tree, int depth) {

        if (depth == maxDepth) {
            result += tree.val;
            return;
        }

        if (tree.left != null) {
            dfs2(tree.left, depth + 1);
        }

        if (tree.right != null) {
            dfs2(tree.right, depth + 1);
        }

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
