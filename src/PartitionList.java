/**
 * Created by tianlan on 8/20/2014.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head==null) return null;
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode walker = helper; //last node of all elements less than x
        ListNode runner = helper; //current node
        while (runner.next!=null){
            if (runner.next.val<x){
                if(walker!=runner){
                    ListNode next = runner.next.next;
                    runner.next.next = walker.next;
                    walker.next = runner.next;
                    runner.next = next;
                }
                else { //all elements up to now are less than x
                    runner = runner.next;
                }
                walker = walker.next; //update walker
            }
            else {
                runner = runner.next;
            }
        }
        return  helper.next;
    }
}
