import java.util.ArrayList;

/**
 * Created by tianlan on 7/31/2014.
 */
public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(Integer.MIN_VALUE);
        helper(root,res);
        return res.get(0);
    }
    private int helper(TreeNode root, ArrayList<Integer> res)
    {
        if(root == null)
            return 0;
        int left = helper(root.left, res);
        int right = helper(root.right, res);
        int cur = root.val + (left>0?left:0)+(right>0?right:0);
        if(cur>res.get(0))
            res.set(0,cur);
        return root.val+Math.max(left, Math.max(right,0));
    }
}
