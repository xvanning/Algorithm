/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

//先遍历链表，得到链表的长度。如果K大于返回空或者异常。
//然后设置两个指针。first指针先走k步，然后同时出发。当first指针走到底，则second指针走到倒数K处。
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k <= 0){
            return null;
        }
        int nodeNum = 0;
        ListNode cur = head;
        while(cur != null){
            nodeNum ++;
            cur = cur.next;
        }
        if(nodeNum < k){
            return null;
            //throw new RuntimeException("k的值比链表长度大");
        }
        ListNode first = head; ListNode second = head;
        while(first != null && ((k --) > 0)){
            first = first.next;
        }
        while(first != null){
            first = first.next;
            second = second.next;
        }
        return second;

    }
}