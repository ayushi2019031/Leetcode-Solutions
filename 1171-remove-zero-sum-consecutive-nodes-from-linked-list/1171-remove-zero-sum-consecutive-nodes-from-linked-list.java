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
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> hash = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head; 
        ListNode curr = dummy;
        int sum = 0; 
        while (curr != null){
            sum += curr.val;
            hash.put(sum, curr.next);
            curr = curr.next; 
        }
        hash.put(sum, null);
        curr = dummy;
        int tp = 0; 
        while (curr != null){
            tp += curr.val;
            if (hash.containsKey(tp)){
                curr.next = hash.get(tp);
            }
            curr = curr.next; 
        }
        if (tp == 0) return null;
        return dummy.next; 
    }
}