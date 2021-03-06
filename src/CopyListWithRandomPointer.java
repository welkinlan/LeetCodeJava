import java.util.HashMap;

/**
 * Created by tianlan on 6/16/2014.
 */

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};

public class CopyListWithRandomPointer {

    //1
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return head;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head,newHead);
        RandomListNode pre = newHead;
        RandomListNode node = head.next;
        while(node!=null)
        {
            RandomListNode newNode = new RandomListNode(node.label);
            map.put(node,newNode);
            pre.next = newNode;
            pre = newNode;
            node = node.next;
        }
        node = head;
        RandomListNode copyNode = newHead;
        while(node!=null)
        {
            copyNode.random = map.get(node.random);
            copyNode = copyNode.next;
            node = node.next;
        }
        return newHead;
    }

    //2
    public RandomListNode copyRandomList2(RandomListNode head) {
        if(head == null)
            return head;
        RandomListNode node = head;
        while(node!=null)
        {
            RandomListNode newNode = new RandomListNode(node.label);
            newNode.next = node.next;
            node.next = newNode;
            node = newNode.next;
        }
        node = head;
        while(node!=null)
        {
            if(node.random != null)
                node.next.random = node.random.next;
            node = node.next.next;
        }
        RandomListNode newHead = head.next;
        node = head;
        while(node != null)
        {
            RandomListNode newNode = node.next;
            node.next = newNode.next;
            if(newNode.next!=null)
                newNode.next = newNode.next.next;
            node = node.next;
        }
        return newHead;
    }
}
