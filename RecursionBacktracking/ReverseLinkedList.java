import java.util.*;
class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
    }
    ListNode(int val, int next){
        this.val = val;
        this.next = next;
    }
}
public class ReverseLinkedList{
    public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;        
    }
}