/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next= head; 
     ListNode L ; ListNode R; ListNode h2; 
        if (left == right) return head;
        int k = 0; ListNode curr = dummy;
        while (k < left){
            curr = curr.next; k += 1; 
        }
        L = curr; 
        while (k < right){
            curr = curr.next; k += 1;
        }
        R = curr; 
        h2 = R.next; 
        R.next = null;
        ListNode attach = reversedList(L);
        curr = dummy; 
        while (curr != null && curr.next != L){
            curr = curr.next;
    //        System.out.println(curr.val);
        }
        curr.next = attach; 
        while (curr.next != null){ curr = curr.next;}
        curr.next = h2; 
        return dummy.next; 
        
    }
    public ListNode reversedList(ListNode head){
        ListNode prev = head; ListNode curr= head.next; 
        while (curr != null){
            ListNode next =curr.next;
            curr.next = prev;
            if (prev == head) prev.next= null;
            prev = curr; 
            curr = next;
        }
      //  System.out.println("PREV VAL: " + prev.val);
        return prev;
    }
}