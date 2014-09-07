/**
 * Created by tianlan on 9/6/14.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null) return null;
        int i=0;
        ListNode runner = head;
        while (runner!=null && i<n){
            runner = runner.next;
            i++;
        }
        if (runner==null){
            return  head.next;
        }
        ListNode walker = head;
        while (runner.next!=null){
            runner = runner.next;
            walker = walker.next;
        }
        walker.next = walker.next.next;
        return head;
    }
}
