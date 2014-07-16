/**
 * Created by tianlan on 7/16/2014.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    //divide into 2 same size lists
    private ListNode mergeSort(ListNode head)
    {
        if(head == null || head.next == null)
            return head;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next!=null && runner.next.next!=null)
        {
            walker = walker.next;
            runner = runner.next.next;
        }
        ListNode head2 = walker.next;
        walker.next = null;
        ListNode head1 = head;
        head1 = mergeSort(head1);
        head2 = mergeSort(head2);
        return merge(head1, head2);
    }
    private ListNode merge(ListNode head1, ListNode head2)
    {
        ListNode helper = new ListNode(0);
        helper.next = head1;
        ListNode pre = helper;
        while(head1!=null && head2!=null)
        {
            if(head1.val<head2.val)
            {
                head1 = head1.next;
            }
            else
            {
                ListNode next = head2.next;
                head2.next = pre.next;
                pre.next = head2;
                head2 = next;
            }
            pre = pre.next;
        }
        if(head2!=null)
        {
            pre.next = head2;
        }
        return helper.next;
    }
}
