import java.util.LinkedList;

/**
 * Created by tianlan on 7/13/14.
 */
public class MinimunDepthBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        int curNum = 0;
        int lastNum = 1;
        int level = 1;
        queue.offer(root);
        while (queue.size()!=0){
            TreeNode cur = queue.poll();
            if(cur.left==null && cur.right==null)
                return level;
            lastNum--;
            if(cur.left!=null)
            {
                queue.offer(cur.left);
                curNum++;
            }
            if(cur.right!=null)
            {
                queue.offer(cur.right);
                curNum++;
            }
            if(lastNum==0) //if all nodes on this level are not leaves
            {
                lastNum = curNum;
                curNum = 0;
                level++;
            }
        }
        return 0;
    }


    //recursive
    public int minDepth1(TreeNode root) {
        if(root == null)
            return 0;
        if(root.left == null)
            return minDepth1(root.right)+1;
        if(root.right == null)
            return minDepth1(root.left)+1;
        return Math.min(minDepth1(root.left),minDepth1(root.right))+1;
    }
}
