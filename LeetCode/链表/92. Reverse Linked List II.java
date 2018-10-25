//迭代，三个指针。按指针走一遍过程。

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        for (int i = 0; i < m - 1; i ++){
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode next = start.next;
        for (int i = 0; i < n - m; i ++){
            start.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = start.next;
        }
        return dummyHead.next;
    }
}