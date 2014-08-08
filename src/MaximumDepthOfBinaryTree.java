import java.util.LinkedList;

/**
 * Created by tianlan on 8/8/2014.
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public int maxDepth1(TreeNode root) {
        if(root == null)
            return 0;
        int level = 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int curNum = 1; //num of nodes left in current level
        int nextNum = 0; //num of nodes in next level
        while(!queue.isEmpty())
        {
            TreeNode n = queue.poll();
            curNum--;
            if(n.left!=null)
            {
                queue.add(n.left);
                nextNum++;
            }
            if(n.right!=null)
            {
                queue.add(n.right);
                nextNum++;
            }
            if(curNum == 0)
            {
                curNum = nextNum;
                nextNum = 0;
                level++;
            }
        }
        return level;
    }
}
