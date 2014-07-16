import java.util.*;

/**
 * Created by tianlan on 7/16/2014.
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int curNum = 0;
        int lastNum = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(!queue.isEmpty())
        {
            TreeNode cur = queue.poll();
            lastNum--;
            list.add(cur.val);
            if(cur.left!=null)
            {
                queue.add(cur.left);
                curNum ++;
            }
            if(cur.right!=null)
            {
                queue.add(cur.right);
                curNum++;
            }
            if(lastNum==0)
            {
                lastNum = curNum;
                curNum = 0;
                res.add(list);
                list = new ArrayList<Integer>();
            }
        }
        Collections.reverse(res);
        return res;
    }

    //my suck one
    public static List<List<Integer>> levelOrderBottom1(TreeNode root) {
        if (root == null){ return null;}
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        HashMap<TreeNode,Integer> nodeLevel = new HashMap<TreeNode, Integer>();
        queue.offer(root);
        nodeLevel.put(root,0);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left==null && right==null) continue;
            if (left != null) {
                queue.offer(left);
                nodeLevel.put(left,nodeLevel.get(node)+1);
            }
            if (right != null) {
                queue.offer(left);
                nodeLevel.put(right,nodeLevel.get(node)+1);
            }
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int maxLevel = 0;
        HashMap<Integer,ArrayList<Integer>> levelInts = new HashMap<Integer, ArrayList<Integer>>();
        for (final TreeNode node : nodeLevel.keySet()){
            int level = nodeLevel.get(node);
            if (level>maxLevel) maxLevel=level;
            if (!levelInts.containsKey(level)) levelInts.put(level, new ArrayList<Integer>(node.val));
            else levelInts.get(level).add(node.val);
        }
        for (int i=maxLevel; i>=0; i--){
            res.add(levelInts.get(i));
        }
        return res;
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
        List<List<Integer>> res = levelOrderBottom(r);

        for (List<Integer> list:res){
            System.out.print("[");
            for(int i:list){
                System.out.print(i+",");
            }
            System.out.println("]");
        }
    }

}
