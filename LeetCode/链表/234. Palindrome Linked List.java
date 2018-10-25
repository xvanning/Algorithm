//双指针，找到后半部门，倒序输出（多种方法，这里使用栈）和前面的一一比较。

import java.util.Stack;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head; ListNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null){
            slow = slow.next;
        }
        fast = head;
        Stack<Integer> reverseList = reverseList(slow);
        while (!reverseList.isEmpty()){
            int cur = reverseList.pop();
            if (cur != fast.val){
                return false;
            }else {
                fast = fast.next;
            }
        }
        return true;
    }

    private Stack<Integer> reverseList(ListNode slow) {
        Stack<Integer> stack = new Stack<>();
        while (slow != null){
            stack.push(slow.val);
            slow = slow.next;
        }
        return stack;
    }
}