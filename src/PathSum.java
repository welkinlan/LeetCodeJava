import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tianlan on 5/24/14.
 */
public class PathSum {

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root != null) {  // not empty tree
            int rootsum = root.val;
            if (root.left == null && root.right == null) { // base case a leaf
                return rootsum == sum;
            }
            sum -= rootsum;
            return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        }
        return false;
    }
}
