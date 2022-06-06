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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode[] l1 = getLinkedNodes(list1, a, b);
        ListNode aj2 = list2; 
        while (aj2 != null && aj2.next != null){
            aj2 = aj2.next;
        }
        aj2.next = l1[1];
        l1[0].next = list2; 
        return list1; 
        
    }
    public ListNode[] getLinkedNodes(ListNode list1, int a, int b){
        ListNode[] ans = new ListNode[2];
        ListNode head = list1; 
        int curr = 0; 
        
        while (head != null){
            if (curr == a - 1){
                ans[0] = head;
            }
            else if (curr == b + 1){
                ans[1] = head; break;
            }
            curr += 1; 
            head = head.next;
        }
        
        return ans; 
    }
}