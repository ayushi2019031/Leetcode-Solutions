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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode curr =  head;
        
        while (curr != null){
            ListNode dub = dummy;
            while (dub.next != null && dub.next.val < curr.val){
                dub = dub.next; 
            }
            ListNode next = dub.next; 
            dub.next = curr;
            ListNode temp = curr.next;
            curr.next = next; 
            curr = temp; 
        }
    return dummy.next;
    }
}