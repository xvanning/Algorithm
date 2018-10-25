// 分两个链表分别存储大于和小于的值

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead1 = new ListNode(-1); ListNode p1 = dummyHead1;
        ListNode dummyHead2 = new ListNode(-1); ListNode p2 = dummyHead2;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x){
                p1.next = cur;
                p1 = p1.next;
            }else {
                p2.next = cur;
                p2 = p2.next;
            }
            cur = cur.next;
        }

        p1.next = dummyHead2.next;
        p2.next = null;

        return dummyHead1.next;
    }
}

