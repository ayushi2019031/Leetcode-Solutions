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
    int ans= 0; 
    int diameterOfBinaryTree(TreeNode* root) {
       fun(root); 
        return ans; 
    }
    int fun(TreeNode* root){
        if (root == nullptr) return 0;
        int l = fun(root->left);
        int r = fun(root->right);
        int height = 1 + max(l, r);
        ans = max(ans, l + r);
        return height; 
    }
    
};