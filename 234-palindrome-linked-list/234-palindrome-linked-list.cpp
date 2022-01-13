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
     return helper(&head, head);  
    }
    bool helper(ListNode** left, ListNode* right){
        if (right == nullptr) return true;
        bool isP = helper(left, right->next);
        if (isP == false){return false;}
        bool isP1 = right->val == (*left)->val;
        *left = (*left)->next;
        return isP1; 
    }
};