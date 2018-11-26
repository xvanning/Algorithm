//先双指针，把链表分成两块。然后递归 + 合并数组

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head; ListNode slow = head;
        ListNode pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        ListNode res = mergeSort(l1,l2);
        return res;
    }

    private ListNode mergeSort(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val){
            l1.next = mergeSort(l1.next,l2);
            return l1;
        }else {
            l2.next = mergeSort(l1,l2.next);
            return l2;
        }
    }
    }

//    private ListNode mergeSort(ListNode l1, ListNode l2) {
//        if (l1 == null) {
//            return l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//        ListNode dummyHead = new ListNode(-1);
//        ListNode cur = dummyHead;
//        while (l1 != null && l2 != null){
//            if (l1.val < l2.val){
//                cur.next = l1;
//                l1 = l1.next;
//            }else {
//                cur.next = l2;
//                l2 = l2.next;
//            }
//            cur = cur.next;
//        }
//        if (l1 != null){
//            cur.next = l1;
//        }
//        if (l2 != null) {
//            cur.next = l2;
//        }
//        return dummyHead.next;
//    }
//}