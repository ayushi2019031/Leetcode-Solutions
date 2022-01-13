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
    int t = 0; 
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        
        
        vector<vector<int>> ans;
        if (root == nullptr) return ans;
        stack<TreeNode> st1; 
        stack<TreeNode> st2;
        st1.push(*root);
        int mod = 1; 
        while (st1.size() > 0 || st2.size() > 0){
            if (mod == 1){
                vector<int> s1; 
                while (!st1.empty()){
                    TreeNode k = st1.top(); st1.pop(); 
                    s1.push_back(k.val);
                    if (k.left != nullptr){st2.push(*k.left);}
                    if (k.right != nullptr){st2.push(*k.right);}
                }
                mod = 0; ans.push_back(s1);
            }
            else {
                vector<int> s2; 
                while (!st2.empty()){
                    TreeNode k = st2.top(); st2.pop(); 
                    s2.push_back(k.val);
                    if (k.right != nullptr){st1.push(*k.right);}
                    if (k.left != nullptr){st1.push(*k.left);}
                }
                mod = 1; ans.push_back(s2);
            }
        }
        return ans; 
    }
};