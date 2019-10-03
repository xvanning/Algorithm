/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
//构建一个虚拟头节点。谁小谁在前面。
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode retHead = dummy;
        while (list1 != null && list2 != null) {
            if(list1.val <= list2.val){
                dummy.next = list1;
                list1 = list1.next;
            }else{
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        while(list1 != null){
            dummy.next = list1;
            list1 = list1.next;
            dummy = dummy.next;
        }
        while(list2 != null){
            dummy.next = list2;
            list2 = list2.next;
            dummy = dummy.next;
        }
        return retHead.next;
    }
}

//递归方法,直接比较两个链表的大小。递归下去。
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        if(list1.val <= list2.val){
            list1.next = Merge(list1.next, list2);
            return list1;
        }else{
            list2.next = Merge(list1,list2.next);
            return list2;
        }
    }
}