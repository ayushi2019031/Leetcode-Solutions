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
    int ans = 0; 
    public int averageOfSubtree(TreeNode root) {
        help(root);
        return ans;
    }
    public int[] help(TreeNode root){
        if (root == null) return new int[]{0, 0};
        int[] a1 = help(root.left);
        int[] a2 = help(root.right);
        
        int sum  = a1[0] + a2[0] + root.val;
        int num = a1[1] + a2[1] + 1; 
        
        int avg = sum/num; 
        if (avg == root.val) ans += 1;
        return new int[]{sum, num};
        
    }
}