//与108题类似。 双指针，快指针，走到尾部。慢指针刚好走到链表中间位置。即为根节点。递归左子树和右子树。

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Given the sorted linked list: [-10,-3,0,5,9],
/**
 *    0
     / \
   -3   9
   /   /
 -10  5
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        TreeNode BSTHead = sortedListToBSTHelper(head,null);
        return BSTHead;
    }

    private TreeNode sortedListToBSTHelper(ListNode head, ListNode tail) {
        if (head == tail){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode temp = new TreeNode(slow.val);
        temp.left = sortedListToBSTHelper(head,slow);
        temp.right = sortedListToBSTHelper(slow.next,tail);
        return temp;
    }
}