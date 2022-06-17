/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int minCameraCover(TreeNode root) {
        return dfs(root, null);
        
    }
    public int dfs(TreeNode root, TreeNode par){
        if (root == null) return 0;
        int ans = 0;
        int k_l = dfs(root.left, root); 
        
        int k_r = dfs(root.right, root);
        if (root.val == -1){
            ans +=  1;
            
        }
        else {
            if (par == null){
                if (!((root.left != null && root.left.val < 0) || (root.right != null && root.right.val < 0))){
                root.val = -1; ans += 1;
                }
                }
            else {
                if (par.val != -1){
                     if (!((root.left != null && root.left.val < 0) || (root.right != null && root.right.val < 0))){
                    par.val = -1; ans += 0;
                     }
                }
               
            }
            
        }
        return ans + k_l+ k_r;
    }
}