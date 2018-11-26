/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
使用虚拟头节点，找到要删除的节点，按照最传统的方式删除。
**/
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null){
            if (prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
            }else {
                prev = prev.next;
            }
        }
        return dummyHead.next;

    }
}

/**
使用递归的方式进行删除。分头节点和头节点之后的链表。仔细体会其中的思路。
**/
public ListNode removeElements(ListNode head, int val) {

        if(head == null)
            return head;

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }