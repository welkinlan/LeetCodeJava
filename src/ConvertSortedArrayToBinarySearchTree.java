/**
 * Created by tianlan on 5/12/14.
 */


public class ConvertSortedArrayToBinarySearchTree {
    static TreeNode n = null;
    public static TreeNode sortedArrayToBST(int[] num) {
        n = new TreeNode(num[0]);
        for (int i=1; i < num.length; i++){
            //insert to bst
            insert(num[i],n);
        }
        return n;

    }

    public static TreeNode insert(int val, TreeNode tn){
        if (tn == null){
            tn = new TreeNode(val);
            n = tn;
        }
        else if (val < tn.val){
            insert(val, tn.left);
            n = n.left;
            System.out.println("left:");
        }
        else{
            insert(val, tn.right);
            n = n.right;
            System.out.println("right:");
        }
        return tn;
    }

    public static void main(String[] args) {
        int num[] = {1,4,5,3,2};
        TreeNode t = sortedArrayToBST(num);
        while (true){
            if (t.left!=null){
                System.out.println("left:"+t.val);
                t = t.left;
            }
            else if (t.right!=null){
                System.out.println("right:"+t.val);
                t = t.right;
            }
            else break;
        }

    }
}
