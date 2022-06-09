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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
     if (root == null) return new TreeNode(val);
    if (root.val < val){
        TreeNode aj = new TreeNode(val);
        aj.left = root;
        return aj; 
    }
    else {
        if (root.left != null && root.right != null){
            root.right = insertIntoMaxTree(root.right, val);
        }
        
        else if (root.left == null && root.right == null){
            root.right = new TreeNode(val);
        }
        else if (root.right != null){root.right = insertIntoMaxTree(root.right, val);}
        else if (root.left != null){root.right = new TreeNode(val);}
        return root;
    }
    }
}