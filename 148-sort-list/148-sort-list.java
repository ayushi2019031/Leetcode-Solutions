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
    public ListNode sortList(ListNode head) {
        ListNode end = head;
      
        return divide(head);
    }
    public ListNode divide(ListNode start){
      
        if (start == null || start.next == null) return start;
        
        ListNode slow = start;
        ListNode fast = start;
        
        while (fast.next != null && fast.next.next != null){
            slow = slow.next; 
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode rr = mid.next;
        mid.next = null;
        ListNode s1 = divide(start);
        ListNode s2 = divide(rr);
        ListNode ans = merge(s1, s2);
        return ans;
    }
    public static ListNode merge(ListNode start, ListNode end)
    {
        if (start == null) return end;
        if (end == null) return start;
        if (start.val <= end.val){
            ListNode kk= start;
            kk.next = merge(start.next, end);
            return kk;
        }
        else {
            ListNode kk = end; 
            kk.next = merge(start, end.next);
            return kk;
        }
            
    }
}