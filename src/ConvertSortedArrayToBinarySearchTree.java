/**
 * Created by tianlan on 5/12/14.
 */


public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] num) {
        if(num==null || num.length==0)
            return null;
        return helper(num,0,num.length-1);
    }
    private TreeNode helper(int[] num, int l, int r)
    {
        if(l>r)
            return null;
        int m = (l+r)/2;
        TreeNode root = new TreeNode(num[m]);
        root.left = helper(num,l,m-1);
        root.right = helper(num,m+1,r);
        return root;
    }
}
