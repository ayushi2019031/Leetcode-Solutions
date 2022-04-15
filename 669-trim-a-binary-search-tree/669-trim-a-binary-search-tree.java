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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) return root; 
        
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        
        if (root.left != null && root.left.val < low){root.left = null;}
        if (root.right != null && root.right.val > high){root.right = null;}
        if (root.val < low) return trimBST(root.right, low, high);
        if (root.val > high) return trimBST(root.left, low, high);
        return root; 
        
        
    }
}