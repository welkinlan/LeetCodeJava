import java.util.HashMap;

/**
 * Created by tianlan on 8/19/2014.
 */
public class RemoveDuplicatesFromSortedListII {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode helper = new ListNode(0); //in case head pointer will be deleted
        helper.next = head;
        ListNode pre = helper;
        ListNode cur = head;
        while (cur != null){
            while (cur.next != null && pre.next.val == cur.next.val){
                cur = cur.next;
            }
            if (pre.next==cur){ //no duplicates
                pre = pre.next;
            }
            else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return helper.next;
    }
}
