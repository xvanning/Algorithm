//双指针，先求出链表长度。然后用slow和fast指针，旋转链表

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode fast = head;
        ListNode slow = head;
        int listLength = 0;
        while (fast.next != null) {
            fast = fast.next;
            listLength ++;
        }
        int rotateLength = listLength + 1 - k % (listLength + 1);
        for (int i = 0; i < rotateLength - 1; i++) {
            slow = slow.next;
        }
        fast.next = dummyHead.next;
        dummyHead.next = slow.next;
        slow.next = null;
        return dummyHead.next;
    }
}

//使用虚拟指针
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        ListNode slow = dummyHead;
        int listLength = 0;
        while (fast.next != null) {
            fast = fast.next;
            listLength ++;
        }
        int rotateLength = listLength  - k % listLength ;
        for (int i = 0; i < rotateLength; i++) {
            slow = slow.next;
        }

        fast.next = dummyHead.next;
        dummyHead.next = slow.next;
        slow.next = null;
        return dummyHead.next;
    }
}