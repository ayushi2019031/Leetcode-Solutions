/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        ListNode* k;
        k = head; 
        stack<ListNode> st1; 
        while (k != nullptr){
            st1.push(*k);
            k = k->next; 
        }
        k = head; 
        while (!st1.empty() && k != nullptr){
            ListNode tt = st1.top(); 
            if (tt.val == k->val){
                st1.pop(); k= k->next; 
            }
            else {
                return false;
            }
        }
        if (!st1.empty()) return false;
        if (k != nullptr) return false;
        return true;
        
    }
};