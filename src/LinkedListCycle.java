/**
 * Created by tianlan on 6/16/2014.
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode walker = head;
        ListNode runner = head;
        while(runner!=null && runner.next!=null)
        {
            walker = walker.next;
            runner = runner.next.next;
            if(walker == runner)
                return true;
        }
        return false;
    }
}
