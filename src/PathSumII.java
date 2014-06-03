import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianlan on 5/31/14.
 */
public class PathSumII {

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> currentVals = new ArrayList<Integer>();
        calcPathSum(root, sum, currentVals, result);
        return result;
    }

    public static void calcPathSum(TreeNode root, int sum, ArrayList<Integer> currentVals, List<List<Integer>> result) {
        if (root != null) {  // not empty tree
            int rootVal = root.val;
            currentVals.add(rootVal);
            //System.out.println(currentVals);
            if (root.left == null && root.right == null) { // base case a leaf
                if (rootVal == sum) {
                    //add a copy of the current node list to prevent overriding later
                    result.add(new ArrayList<Integer>(currentVals));
                    //System.out.println("result: "+result);
                }
                //delete the leaf from the current node list and go back to parent
                currentVals.remove(currentVals.size()-1);
                return;
            }
            sum -= rootVal;
            calcPathSum(root.left, sum, currentVals, result);
            calcPathSum(root.right, sum, currentVals, result);
            //if this node has been inspected fully on all its left and right children
            //then delete it from the current node list. It must be the last one of the arraylist
            currentVals.remove(currentVals.size()-1);
            //System.out.println("No l or r: "+currentVals);
        }
        return;
    }

    public static void main(String[] args){
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(4);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(11);
        TreeNode t5 = new TreeNode(13);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(2);
        TreeNode t9 = new TreeNode(5);
        TreeNode t10 = new TreeNode(1);
        t1.left = t2; t1.right = t3;
        t2.left = t4;
        t3.left = t5; t3.right = t6;
        t4.left = t7; t4.right = t8;
        t6.left = t9; t6.right = t10;

        List<List<Integer>> result = pathSum(t1,22);
        for (List<Integer> list : result){
            for (int ele : list){
                System.out.print(ele+",");
            }
            System.out.println();
        }


    }
}
