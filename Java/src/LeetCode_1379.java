import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/submissions/
public class LeetCode_1379 {

    public static void main(String[] args){

    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(cloned);

        TreeNode result = null;

        while (queue.size() > 0) {
            TreeNode poll = queue.poll();
            if (poll.val == target.val) {
                result = poll;
                break;
            }

            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }

        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}