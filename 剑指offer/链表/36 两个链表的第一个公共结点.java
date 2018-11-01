/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
//双指针，循环走。有个小坑
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode first = pHead1; ListNode second = pHead2;
        while(first != second){
            if(first == null){ //注意不能是first.next == null。不然会陷入死循环。
                first = pHead2;
            }else{
                first = first.next;
            }
            if(second == null){//注意不能是second.next == null。不然会陷入死循环。
                second = pHead1;
            }else{
                second = second.next;
            }
        }
        return first;
    }
}