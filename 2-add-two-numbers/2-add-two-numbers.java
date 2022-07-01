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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr1 = l1; ListNode curr2 = l2; 
        ListNode head = dummy;
        int carry = 0; 
        while (curr1 != null && curr2 != null){
            int sum = curr1.val + curr2.val + carry;
            int digit = sum % 10; 
             carry = sum/10;
            dummy.next = new ListNode(digit);
            dummy = dummy.next;
            curr1 = curr1.next; curr2 = curr2.next;
        }
        while (curr1 != null){
            int sum = curr1.val + carry;
            int digit = sum % 10; 
            carry = sum/10;
            dummy.next = new ListNode(digit);
            dummy = dummy.next;
            curr1 = curr1.next;
        }
        while (curr2 != null){
            int sum = curr2.val + carry;
            int digit = sum % 10; 
             carry = sum/10;
            dummy.next = new ListNode(digit);
            dummy = dummy.next;
            curr2 = curr2.next; 
        }
        if (carry != 0){dummy.next = new ListNode(carry); dummy = dummy.next;}
        return head.next;
    }
}