/**
 * Created by tianlan on 9/7/14.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode pre = temp;
        int carry = 0;
        while (l1!=null && l2!=null){
            int v = l1.val+l2.val+carry;
            carry = v/10;
            pre.next = new ListNode(v%10);
            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1!=null){
            int v = l1.val+carry;
            carry = v/10;
            pre.next = new ListNode(v%10);
            pre = pre.next;
            l1 = l1.next;
        }
        while (l2!=null){
            int v = l2.val+carry;
            carry = v/10;
            pre.next = new ListNode(v%10);
            pre = pre.next;
            l2 = l2.next;
        }
        if (carry!=0){
            pre.next = new ListNode(carry);
        }
        return temp.next;
    }
}
