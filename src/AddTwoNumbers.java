/**
 * Created by tianlan on 9/7/14.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newTemp = new ListNode(0);
        ListNode newHead = newTemp;
        int carry = 0;
        while (l1!=null && l2!=null){
            int v = l1.val+l2.val+carry;
            carry = v/10;
            newHead.next = new ListNode(v%10);
            newHead = newHead.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1!=null){
            int v = l1.val+carry;
            carry = v/10;
            newHead.next = new ListNode(v%10);
            newHead = newHead.next;
            l1 = l1.next;
        }
        while (l2!=null){
            int v = l2.val+carry;
            carry = v/10;
            newHead.next = new ListNode(v%10);
            newHead = newHead.next;
            l2 = l2.next;
        }
        if (carry!=0){
            newHead.next = new ListNode(carry);
        }
        return newTemp.next;
    }
}
