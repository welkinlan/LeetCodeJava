/**
 * Created by tianlan on 7/16/2014.
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;
        ListNode helper = new ListNode(0);
        //用一个辅助指针来做表头避免处理改变head的时候的边界情况
        ListNode pre = helper;
        ListNode cur = head;
        while(cur!=null)
        {
            ListNode next = cur.next;
            pre = helper;
            while(pre.next!=null && pre.next.val<cur.val)
            {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return helper.next;
    }

    public static ListNode insertionSortList1(ListNode head) {
        if (head == null) return null;
        ListNode newHead = head;
        ListNode pos = newHead.next;
        while (pos != null) {
            ListNode temp = pos;
            pos = pos.next;
            ListNode nextNode = newHead.next;
            ListNode lastNode = newHead;
            while (nextNode != temp) {
                if (temp.val < nextNode.val) {
                    lastNode.next = temp;
                    temp.next = nextNode;
                    break;
                }
                lastNode = lastNode.next;
                nextNode = nextNode.next;
            }

            if (nextNode == temp) {
                if (temp.val > lastNode.val) {
                    lastNode.next = temp;
                    temp.next = pos;
                }
                else {
                    temp.next = lastNode;
                    lastNode.next = pos;
                    newHead = temp;
                }
            }
            ListNode nn = newHead;
            while (nn!=null){
                System.out.print(nn);
                nn = nn.next;
            }
            System.out.println();
        }
        return newHead;
    }

    public static void main(String[] args){
        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(8);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode n = insertionSortList1(n1);
        while (n!=null){
            System.out.print(n);
            n = n.next;
        }
    }
}