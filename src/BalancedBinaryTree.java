/**
 * Created by tianlan on 5/31/14.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        if (getHeight(root) == -1)
            return false;

        return true;
    }

    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if (left == -1 || right == -1) //left subtree or right subtree is not balanced
            return -1;

        if (Math.abs(left - right) > 1) { //the height of left subtree and right subtree differs than 1
            return -1;
        }

        return Math.max(left, right) + 1; //the height of the tree
    }
}