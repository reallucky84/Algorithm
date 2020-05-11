// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
public class LeetCode_1315 {

    int result = 0;

    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, null, null);
        return result;
    }

    public void dfs(TreeNode tree, TreeNode parent, TreeNode grand){
        if(grand != null && grand.val %2 == 0){
            result += tree.val;
        }
        if(tree.left != null){
            dfs(tree.left, tree, parent);
        }

        if(tree.right != null){
            dfs(tree.right, tree, parent);
        }
    }

    private class TreeNode {
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
