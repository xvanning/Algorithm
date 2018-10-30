/*
public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
*/
public class Solution {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        //复制，插入新节点
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode next = cur.next;
            RandomListNode cloneNode = new RandomListNode(cur.label);
            cloneNode.next = cur.next;
            cur.next = cloneNode;
            cur = next;
        }
        //建立random链接
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            RandomListNode next = clone.next;
            if (cur.random != null) {
                clone.random = cur.random.next;
            }
            cur = next;
        }
        //拆分
        cur = pHead;
        RandomListNode cloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return cloneHead;
    }
}