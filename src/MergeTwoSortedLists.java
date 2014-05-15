/**
 * Created by tianlan on 4/29/14.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return val+"";
    }

}

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode root = null;
        if (l1==null) return l2;
        if (l2==null) return l1;
        if (l2==null && l1==null) return null;
        if (l1.val<l2.val){
            root = new ListNode(l1.val);
            l1 = l1.next;
        }
        else {
            root = new ListNode(l2.val);
            l2 = l2.next;
        }
        //reference issue
        ListNode temp = root;
        while (l2 != null || l1 != null){
            if (l2 == null) {
                while (l1 != null){
                    temp.next = new ListNode(l1.val);
                    l1 = l1.next;
                    temp = temp.next;
                }
                return root;
            }
            if (l1 == null) {
                while (l2 != null){
                    temp.next = new ListNode(l2.val);
                    l2 = l2.next;
                    temp = temp.next;
                }
                return root;
            }
            if (l1.val > l2.val){
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
                temp = temp.next;
            }
            else{
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
                temp = temp.next;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = a;
        ListNode d = b;
        for (int i=0; i<5; i++){
            c.next = new ListNode(i+2);
            d.next = new ListNode(i+4);
            c = c.next;
            d = d.next;
        }

        ListNode gg = mergeTwoLists(a,b);
        while (gg!=null){
            System.out.print(gg.val);
            gg = gg.next;
        }
    }
}
