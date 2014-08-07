/**
 * Created by tianlan on 8/6/2014.
 */

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode lastHead = root;
        TreeLinkNode pre = null;
        TreeLinkNode curHead = null;
        while(lastHead!=null)
        {
            TreeLinkNode lastCur = lastHead;
            while(lastCur != null)
            {
                if(lastCur.left!=null)
                {
                    if(curHead == null)
                    {
                        curHead = lastCur.left;
                        pre = curHead;
                    }
                    else
                    {
                        pre.next = lastCur.left;
                        pre = pre.next;
                    }
                }
                if(lastCur.right!=null)
                {
                    if(curHead == null)
                    {
                        curHead = lastCur.right;
                        pre = curHead;
                    }
                    else
                    {
                        pre.next = lastCur.right;
                        pre = pre.next;
                    }
                }
                lastCur = lastCur.next;

            }
            lastHead = curHead;
            curHead = null;
        }
    }
}

