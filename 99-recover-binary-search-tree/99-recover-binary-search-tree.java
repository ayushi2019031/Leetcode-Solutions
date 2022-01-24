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
     TreeNode prev; 
     TreeNode first; 
     TreeNode middle;
     TreeNode last;
    public void recoverTree(TreeNode root) {
        rec(root);
        if (last== null){
            if (first != null && middle != null){
                int kk = first.val; 
                first.val = middle.val; 
                middle.val = kk; 
            }
        }
        else {
            int kk = first.val; 
                first.val = last.val; 
                last.val = kk; 
        }
    }
    public void rec(TreeNode root){
        if (root == null) return;
        rec(root.left);
        
            if (prev != null && root.val < prev.val){
                if (first == null && middle == null){
                    first = prev; middle = root;
                } 
                else {
                    last = root;
                }
                
            }
        prev = root; 
        rec(root.right); 
    }
    
}