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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr =head; 
        int s = 0; 
        while (curr != null){s += 1; curr = curr.next;}
        curr = head; 
        ListNode[] arr = new ListNode[s];
        System.out.println(s); 
        for (int i = 0; i < s; i++){
            arr[i] = curr; 
            ListNode next = curr.next; 
            curr.next = null; 
            curr = next; 
        }
        // System.out.println(Arrays.toString(arr)); 
        ListNode temp = arr[k - 1]; 
        arr[k - 1] = arr[s - k ]; 
        arr[s - k ] = temp; 
        ListNode dummy = new ListNode(0); 
        curr = dummy; 
        int ss = 0; 
        while (ss < arr.length){
            curr.next = arr[ss]; 
            ss += 1; 
            curr = curr.next; 
        }
        return dummy.next; 
        
    }
}