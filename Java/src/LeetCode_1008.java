public class LeetCode_1008 {

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        buildTree(preorder, root, 1);
        return root;

    }

    public static void buildTree(int[] preorder, TreeNode parent, int index) {
        if (index == preorder.length || parent == null) {
            return;
        }

        if (preorder[index] < parent.val) {
            if (parent.left == null) {
                parent.left = new TreeNode(preorder[index]);
            } else {

            }
        } else {
            if (parent.right == null) {
                parent.right = new TreeNode(preorder[index]);
            } else {

            }
        }
    }

    public static class TreeNode {
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
