import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tianlan on 6/16/2014.
 */
public class BinaryTreePostorderTraversal {

    //recursive
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        helper(root, result);
        return result;
    }

    private static void helper(TreeNode node, List<Integer> result){
        if (node == null) {
            return;
        }
        helper(node.left, result);
        helper(node.right, result);
        result.add(node.val);
    }

    //iterative
    public static List<Integer> postorderTraversal1(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        if(root == null)
            return result;

        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        TreeNode pre = null;
        while (!stack.isEmpty()){
            TreeNode cur = stack.peek();
            //go down
            if (pre == null || pre.left == cur || pre.right == cur){
                if (cur.left != null) {
                    stack.push(cur.left);
                }
                else if (cur.right != null){
                    stack.push(cur.right);
                }
                else { //leaf
                    result.add(cur.val);
                    stack.pop();
                }
            }
            //go back . left tree done . right tree undone
            else if (cur.left == pre && cur.right != null){
                stack.push(cur.right);
            }
            //go back . both done
            else {
                result.add(cur.val);
                stack.pop();
            }
            pre = cur;
        }

        return result;
    }

    //morris iteration
    //....to be continue

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

        List<Integer> result = postorderTraversal(r);
        for (int i=0; i<result.size(); i++){
            System.out.print(result.get(i));
        }

    }
}
