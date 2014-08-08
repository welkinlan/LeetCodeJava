import java.util.ArrayList;

/**
 * Created by tianlan on 8/8/2014.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    boolean helper(TreeNode root, int min, int max)
    {
        if(root == null)
            return true;
        if(root.val <= min || root.val >= max)
            return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    public boolean isValidBST1(TreeNode root) {
        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(null);
        return helper(root, pre);
    }
    private boolean helper(TreeNode root, ArrayList<Integer> pre)
    {
        if(root == null)
            return true;
        boolean left = helper(root.left,pre);
        if(pre.get(0)!=null && root.val<=pre.get(0))
            return false;
        pre.set(0,root.val);
        return left && helper(root.right,pre);
    }

}
