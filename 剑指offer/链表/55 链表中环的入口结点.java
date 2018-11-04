/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
/*解释： https://github.com/CyC2018/CS-Notes/blob/master/notes/%E5%89%91%E6%8C%87%20offer%20%E9%A2%98%E8%A7%A3.md#23-%E9%93%BE%E8%A1%A8%E4%B8%AD%E7%8E%AF%E7%9A%84%E5%85%A5%E5%8F%A3%E7%BB%93%E7%82%B9 */
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        // 先判断有没有环
        //因为一开始，slow fast指针是在同一个位置，要进入循环需要使用do while
        ////do while循环参考剑指offer 48
        do {
            // 没有环,返回
            if (slow.next == null || fast.next.next == null) {
                return null;
            }
            // 不断循环，直到相遇
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        // 循环出来的话就是有环，且此时fast==slow.
        fast = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}