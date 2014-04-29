import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by tianlan on 4/28/14.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreeZigzagLevelOrderTraversal {

    static ArrayList<ArrayList<Integer>> result = new  ArrayList<ArrayList<Integer>>();


    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return result;
        DFS(root,0);
        ArrayList<ArrayList<Integer>> newResult = new  ArrayList<ArrayList<Integer>>();

        for (int i=0; i<result.size(); i++){
            if (i%2 == 0){
                ;
            }
            else{
                Collections.reverse(result.get(i));
            }

        }
        return result;
    }

    public static void DFS(TreeNode t, int l){
        //System.out.println(t.val);
        if (l >= result.size()){
            result.add(l, new ArrayList(Arrays.asList(t.val)));
        }
        else{
            result.get(l).add(t.val);
        }
        if (t.left != null) {

            DFS(t.left, l + 1);
        }
        if(t.right != null){

            DFS(t.right, l+1);
        }
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



        zigzagLevelOrder(r);
        System.out.println(result);

    }
}
