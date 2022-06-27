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
     Stack<ListNode> s1 = new Stack<>(); 
     Stack<ListNode> s2 = new Stack<>(); 
        ListNode h1 = l1; 
        ListNode h2 = l2; 
        while (h1 != null){s1.push(h1); h1 = h1.next; }
        while (h2 != null){s2.push(h2); h2 = h2.next; }
        
        ListNode dummy = null; 
        int rem = 0; 
        while (!s1.isEmpty() && !s2.isEmpty()){
            int sum = s1.pop().val + s2.pop().val + rem;
            int digit = sum %10; 
            int carry = sum/10; 
            
            ListNode aj = new ListNode(digit);
            aj.next= dummy;
            dummy = aj; 
            rem = carry; 
        }
        while (!s1.isEmpty()){
            int sum = s1.pop().val + rem; 
            int digit = sum % 10; 
            int carry = sum/10; 
            ListNode aj = new ListNode(digit);
            aj.next = dummy; 
            dummy = aj; 
            rem = carry; 
        }
        while (!s2.isEmpty()){
            int sum = s2.pop().val + rem; 
            int digit = sum % 10; 
            int carry = sum/10; 
            ListNode aj = new ListNode(digit);
            aj.next = dummy; 
            dummy = aj; 
            rem = carry; 
        }
        if (rem > 0){
            ListNode aj = new ListNode(rem);
            aj.next= dummy; 
            dummy = aj; 
        }
        return dummy; 
    }
}