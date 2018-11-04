/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
//迭代，三指针
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode pre = dummy;
        ListNode cur = pHead;
        while (cur != null && cur.next != null) {
            ListNode next = cur.next;
            if (cur.val == next.val) {
                while (next != null && cur.val == next.val) {
                    next = next.next;
                }
                cur = next;
                pre.next = cur;
            } else {
                pre = cur;
                cur = next;
            }
        }
        return dummy.next;
    }
}

// 递归法
/*
 * public class ListNode { int val; ListNode next = null;
 *
 * ListNode(int val) { this.val = val; } }
 */
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode next = pHead.next;
        if(pHead.val == next.val){
            while(next != null && pHead.val == next.val){
                next = next.next;
            }
            return deleteDuplication(next);
        }else{
            pHead.next = deleteDuplication(next);
            return pHead;
        }
    }
}