/**
 * Created by tianlan on 9/6/14.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head==null) return null;
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode pre = helper;
        ListNode cur = head;
        while(cur!=null && cur.next!=null)
        {
            ListNode next = cur.next.next;
            cur.next.next = cur;
            pre.next = cur.next;
            cur.next = next;
            pre = cur;
            cur = next;
        }
        return helper.next;
    }

}
