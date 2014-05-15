import java.util.List;

/**
 * Created by tianlan on 5/13/2014.
 */

public class ReverseNodesInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k==0) return null;
        else if (k==1) return head;
        //first node of this group
        ListNode start = head;
        //current inspected node
        ListNode now = start;
        //the head node of the final reversed list
        ListNode reverseStart = start;
        //the last node of the former reverse group
        ListNode lastNodeOfFormerReversedGroup = start;
        boolean done = false;
        int i = 0;
        while (!done) {
            now = now.next;
            i = i+1;
            if (i%k == 0){
                //first node of the reversed group
                ListNode firstNodeOftThisReversedGroup = reverseKNodes(start, k);
                if (i == k){
                    reverseStart = firstNodeOftThisReversedGroup;
                }
                else{
                    lastNodeOfFormerReversedGroup.next = firstNodeOftThisReversedGroup;
                }
                lastNodeOfFormerReversedGroup = start;
                start = now;
            }
            if (now == null){
                //if not enough elements for k-group
                if (i < k) return start;
                lastNodeOfFormerReversedGroup.next = start;
                done = true;
            }
            //System.out.println(start+","+now+","+i);
        }
        return reverseStart;
    }

    public static ListNode reverseKNodes(ListNode start, int k){
        int i = 1;
        ListNode end = start.next;
        while (i < k){
            ListNode next = end.next;
            end.next = start;
            start = end;
            end = next;
            i++;
        }
        return start;
    }

    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        ListNode rHead = reverseKGroup(a,7);
        while (rHead!= null){
            System.out.print(rHead);
            rHead = rHead.next;
        }

    }

}
