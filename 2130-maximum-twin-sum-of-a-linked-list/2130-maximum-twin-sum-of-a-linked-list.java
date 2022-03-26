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
    public int pairSum(ListNode head) {
        ListNode curr = head; 
        int n = 0; 
        while (curr != null){
            curr = curr.next; n += 1; 
        }
        int ss = 0; 
        curr = head; 
        Stack<ListNode> stack = new Stack<>(); 
        while (ss < (n/2)){
            stack.push(curr);
            ss += 1;
            curr = curr.next; 
        }
        int max = 0; 
        while (curr != null){
            System.out.println(curr.val);
            max = Math.max(max, curr.val + stack.pop().val);
            curr = curr.next; 
        }
        return max; 
    }
}