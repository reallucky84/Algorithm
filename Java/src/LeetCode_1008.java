

public class LeetCode_1008 {

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);

        for(int i = 1; i < preorder.length;i++){
            root = insert(root, preorder[i]);
        }

        return root;
    }

    public TreeNode insert(TreeNode root, int key){
        if(root == null){
            return new TreeNode(key);
        }

        if(root.val >= key){
            root.left = insert(root.left, key);
        } else{
            root.right = insert(root.right, key);
        }
        return root;
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
