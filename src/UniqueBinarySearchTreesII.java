import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianlan on 8/14/2014.
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return helper(1,n);
    }
    private List<TreeNode> helper(int left, int right)
    {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(left>right)
        {
            res.add(null);
            return res;
        }
        for(int i=left;i<=right;i++)
        {
            List<TreeNode> leftList = helper(left,i-1);
            List<TreeNode> rightList = helper(i+1,right);
            for(int j=0;j<leftList.size();j++)
            {
                for(int k=0;k<rightList.size();k++)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = leftList.get(j);
                    root.right = rightList.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
}
