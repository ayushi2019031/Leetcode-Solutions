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
    public int maxLevelSum(TreeNode root) {
       Queue<TreeNode> q = new LinkedList<>(); 
        q.add(root);
        int max = Integer.MIN_VALUE; 
        int level = 0; 
        int ans = 0; 
        while (!q.isEmpty()){
            level += 1;
            int sz = q.size(); 
            int level_sum = 0; 
            while (sz > 0){
                TreeNode k = q.poll(); 
                level_sum += k.val;
                sz -= 1; 
                if (k.left != null) q.add(k.left);
                if (k.right != null) q.add(k.right);
            }
            if (level_sum > max){max = level_sum; ans = level;}
        }
    return ans; 
    }
}