import java.util.HashMap;

/**
 * Created by tianlan on 5/28/2014.
 */
public class RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        HashMap<Integer,Boolean> isDuplicate = new HashMap<Integer, Boolean>();
        isDuplicate.put(head.val,Boolean.TRUE);
        ListNode prev = head;
        ListNode now = head.next;
        while (now != null){
            //not duplicate
            if (!isDuplicate.containsKey(now.val)){
                isDuplicate.put(now.val,Boolean.TRUE);
                prev = now;
            }
            //duplicate
            else{
                prev.next = now.next;
            }
            now = now.next;
        }
        return head;
    }

    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(3);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        deleteDuplicates(a);
        while (a!= null){
            System.out.print(a);
            a = a.next;
        }

    }
}
