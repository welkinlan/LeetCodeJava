/**
 * Created by tianlan on 8/7/2014.
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length==0 || postorder.length==0 || inorder.length!=postorder.length) return null;
        TreeNode root = new TreeNode(postorder[postorder.length]);


        return root;
    }
}
