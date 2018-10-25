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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> stack3 = new Stack<>();
        while (l1 != null){
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        int tmp = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || tmp != 0){
            if (!stack1.isEmpty()) {
                tmp += stack1.pop();
            }
            if (!stack2.isEmpty()){
                tmp += stack2.pop();
            }
            stack3.push(tmp % 10);
            tmp = tmp / 10;
        }
        while (!stack3.isEmpty()){
            p.next = new ListNode(stack3.pop());
            p = p.next;
        }
        return dummyHead.next;
    }
}