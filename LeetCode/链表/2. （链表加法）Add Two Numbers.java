/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        int tmp = 0;
        while (l1 != null || l2 != null || tmp != 0){
            if (l1 != null){
                tmp += l1.val;
                l1 = l1.next;
            }
            if (l2 != null){
                tmp += l2.val;
                l2 = l2.next;
            }

            p.next = new ListNode(tmp % 10);
            p = p.next;
            tmp = tmp / 10;
        }
        return dummyHead.next;
    }
}