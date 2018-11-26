//迭代：三个指针，pre,cur,next

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}


//头插法：先构建一个dummyHead。和上面的基本一样
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;

            cur.next = dummyHead.next;
            dummyHead.next = cur;
            cur = next;
        }
        return dummyHead.next;
    }
}

//递归
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){ // 链表为空或者链表只有一个元素
            return head;
        }
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverseList(next);
        next.next = head;
        return newHead;
    }
}