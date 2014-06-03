import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianlan on 6/2/14.
 */
public class MergeKSortedLists {
    //method one: merge sort
    //O(nklogk)
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists==null || lists.size()==0)
            return null;
        return helper(lists,0,lists.size()-1);
    }
    private ListNode helper(ArrayList<ListNode> lists, int l, int r)
    {
        if(l<r)
        {
            int m = (l+r)/2;
            return merge(helper(lists,l,m),helper(lists,m+1,r));
        }
        return lists.get(l);
    }
    private ListNode merge(ListNode l1, ListNode l2)
    {
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode cur = dummy;
        while(l1!=null && l2!=null)
        {
            if(l1.val<l2.val)
            {
                l1 = l1.next;
            }
            else
            {
                ListNode next = l2.next;
                cur.next = l2;
                l2.next = l1;
                l2 = next;
            }
            cur = cur.next;
        }
        if(l2!=null)
            cur.next = l2;
        return dummy.next;
    }

    /*
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
    PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(10,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode n1, ListNode n2)
            {
                return n1.val-n2.val;
            }
    });
    for(int i=0;i<lists.size();i++){
        ListNode node = lists.get(i);
        if(node!=null) heap.offer(node);
    }
    ListNode head = null;
    ListNode pre = head;
    while(heap.size()>0)
    {
        ListNode cur = heap.poll();
        if(head == null)
        {
            head = cur;
            pre = head;
        }
        else
        {
            pre.next = cur;
        }
        pre = cur;
        if(cur.next!=null) heap.offer(cur.next);
    }
    return head;
}
     */
}
