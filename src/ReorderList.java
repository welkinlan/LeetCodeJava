import sun.awt.image.ImageWatched;

import java.util.LinkedList;

/**
 * Created by tianlan on 6/16/2014.
 */
public class ReorderList {
    public static void reorderList(ListNode head) {
        if (head==null) return;
        LinkedList<ListNode> stack = new LinkedList<ListNode>();
        ListNode node = head;
        int num = 0;
        while (node!=null){ //push all elements in the stack
            stack.push(node);
            node = node.next;
            num ++;
        }

        int i = 0;
        node = head;
        while (i < num/2){ //traverse the first half
            ListNode lastToTail = stack.pop();
            lastToTail.next = node.next;
            node.next = lastToTail;
            node = lastToTail.next; //go to next original element
            i++;
        }
        node.next = null;

    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        //ListNode f = new ListNode(6);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        //e.next = f;

        reorderList(a);

        while (a!=null){
            System.out.print(a.val);
            a = a.next;
        }
    }
}
