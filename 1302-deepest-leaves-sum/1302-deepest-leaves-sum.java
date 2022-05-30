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
    int maxdepth = 0; 
    public int deepestLeavesSum(TreeNode root) {
        HashMap<Integer, Integer> hash = new HashMap<>(); 
        fun(hash, root, 0); 
        return hash.get(maxdepth);
    }
    public void fun(HashMap<Integer, Integer> hash, TreeNode root, int ht){
        if (root == null) return ; 
        fun(hash, root.left, ht + 1);
        fun(hash, root.right, ht + 1);
        maxdepth = Math.max(maxdepth, ht); 
        hash.put(ht, hash.getOrDefault(ht, 0) + root.val); 
        
    }
}