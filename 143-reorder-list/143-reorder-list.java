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
    public ListNode reversedList(ListNode head){
        if (head == null || head.next == null) return head;
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
    public void reorderList(ListNode head) {
        if (head.next == null) return ;
        ListNode slow = head; ListNode fast = head;
        while (fast != null && fast.next != null){slow = slow.next; fast = fast.next.next;}
        ListNode h2 = slow.next;
        h2 = reversedList(h2);
        slow.next = null;
        ListNode dummy = new ListNode(0);
        ListNode curr1 = head; ListNode curr2 = h2;ListNode curr = dummy;
        while (curr1 != null && curr2 != null){
            curr.next = curr1; 
            curr = curr.next; curr1 = curr1.next;
            curr.next = curr2;
            curr = curr.next; curr2 = curr2.next;
        }
        if (curr1 != null) curr.next= curr1;
        if (curr2 != null) curr.next= curr2;
        head = dummy.next;
    }
}