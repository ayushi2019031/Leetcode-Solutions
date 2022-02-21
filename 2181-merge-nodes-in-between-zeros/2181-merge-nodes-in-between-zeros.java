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
    public ListNode mergeNodes(ListNode head) {
     ListNode kk = head; 
        while (kk.next != null){
            ListNode t = kk.next;
            int sum = 0; 
            while (t.next != null && t.val != 0){
                sum += t.val;
                t = t.next; 
                // System.out.println(t.val);
            }
            ListNode jk = new ListNode(sum);
            kk.next = jk; 
            jk.next = t; 
         kk = t;    
        }
        ListNode start =head.next;
        while (start != null){
            start.next =  start.next.next;
            start = start.next;
        }
        return head.next;
    }
}