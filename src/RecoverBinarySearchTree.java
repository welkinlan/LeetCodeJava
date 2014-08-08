import java.util.ArrayList;

/**
 * Created by tianlan on 8/8/2014.
 */
public class RecoverBinarySearchTree {
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;
        ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
        pre.add(null);
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        helper(root,pre, res);
        if(res.size()>0)
        {
            int temp = res.get(0).val;
            res.get(0).val = res.get(1).val;
            res.get(1).val = temp;
        }
    }
    private void helper(TreeNode root, ArrayList<TreeNode> pre, ArrayList<TreeNode> res)
    {
        if(root == null)
        {
            return;
        }
        helper(root.left, pre, res);
        if(pre.get(0)!=null && pre.get(0).val>root.val)
        {
            if(res.size()==0)
            {
                res.add(pre.get(0));
                res.add(root);
            }
            else
            {
                res.set(1,root);
            }
        }
        pre.set(0,root);
        helper(root.right,pre,res);
    }

}
