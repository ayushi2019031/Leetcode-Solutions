/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* last; 
    void flatten(TreeNode* root) {
        if (root == nullptr) return; 
        flatten(root->left); flatten(root->right);
        TreeNode* lt = root->left; 
        TreeNode* rt = root->right; 
        cout << root->val << endl;
        if (lt == nullptr && rt == nullptr) return; 
        root->right = lt;
        TreeNode* ref = root; 
      //  cout << root->val << " " << ref->right->val << endl;
        root->left = nullptr;
        while (ref->right != nullptr){cout << ref->val <<" "; ref = ref->right;}
        cout << ref->val << endl;
        ref->right = rt; 
        
    }
};