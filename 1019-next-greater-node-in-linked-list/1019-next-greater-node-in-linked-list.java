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
    public int[] nextLargerNodes(ListNode head) {
        ListNode curr = head; 
        int n = 0; 
        while (curr != null){
            n += 1; 
            curr = curr.next; 
        }
        int[] ref = new int[n]; 
        curr = head; int s = 0;  
        while (curr != null){
            ref[s] = curr.val; 
            s += 1; curr = curr.next; 
        }
        
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n]; 
        for (int i = 0; i < n; i++){
            if (stack.isEmpty()){
                stack.push(i); 
            }
            else {
                while (!stack.isEmpty() && ref[stack.peek()] < ref[i]){
                    ans[stack.pop()] = ref[i]; 
                }
                stack.push(i); 
            }
        }
        return ans; 
    }
}