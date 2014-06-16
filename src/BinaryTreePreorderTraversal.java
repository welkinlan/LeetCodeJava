import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tianlan on 6/16/2014.
 */
public class BinaryTreePreorderTraversal {
    //recursive
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        helper(root, result);
        return result;
    }

    private static void helper(TreeNode node, List<Integer> result){
        if (node == null) {
            return;
        }
        result.add(node.val);
        helper(node.left, result);
        helper(node.right, result);
    }

    //iterative
    public static List<Integer> preorderTraversal1(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        if(root == null)
            return result;

        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while (root != null || !stack.isEmpty()){
            if(root!=null) //print and go left
            {
                stack.push(root);
                result.add(root.val);
                root = root.left;
            }
            else //go back and go to right
            {
                root = stack.pop();
                root = root.right;
            }
        }

        return result;
    }

    public static void main(String[] args) {
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

        List<Integer> result = preorderTraversal(r);
        for (int i=0; i<result.size(); i++){
            System.out.print(result.get(i));
        }

    }

}
