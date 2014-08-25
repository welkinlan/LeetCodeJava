/**
 * Created by tianlan on 8/24/14.
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) return null;
        ListNode p1 = head;
        ListNode p2 = head;
        int length = 0;
        while (p2!=null && length<n){
            p2 = p2.next;
            length++;
        }
        //n > length
        if (p2==null){
            p2 = head;
            n %= length;
            int i = 0;
            while(i<n)
            {
                p2 = p2.next;
                i++;
            }
        }
        while (p2.next!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = head;
        ListNode newHead = p1.next;
        p1.next = null;
        return newHead;
    }
}
