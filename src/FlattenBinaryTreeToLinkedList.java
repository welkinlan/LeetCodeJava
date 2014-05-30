import java.util.ArrayList;

/**
 * Created by tianlan on 5/29/2014.
 */
public class FlattenBinaryTreeToLinkedList {

    public static void flatten(TreeNode root) {
        ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
        pre.add(null);
        helper(root, pre);
    }

    private static void helper(TreeNode root, ArrayList<TreeNode> pre) {
        if (root == null)
            return;
        //System.out.println(root.val+","+pre.size());
        TreeNode right = root.right;
        if (pre.get(0) != null) {
            pre.get(0).left = null;
            pre.get(0).right = root;
        }
        pre.set(0, root);
        helper(root.left, pre);
        helper(right, pre);
    }

    public static void main(String[] args){
        TreeNode r = new TreeNode(0);
        TreeNode r1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3= new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        TreeNode r7 = new TreeNode(7);
        TreeNode r8 = new TreeNode(8);
        r.left = r1;
        r.right = r2;
        r1.left = r3;
        r1.right = r4;
        r2.left = r5;
        r2.right = r6;
        r5.left = r7;
        r5.right = r8;
        flatten(r);

        while (r!=null){
            System.out.print(r.val);
            r = r.right;
        }
    }
}
