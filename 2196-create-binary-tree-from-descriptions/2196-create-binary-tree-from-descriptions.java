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
    public TreeNode createBinaryTree(int[][] des) {
        HashMap<Integer, TreeNode> hash = new HashMap<>(); 
        int len = des.length; 
        for (int i = 0; i < len; i++){
            TreeNode par; TreeNode child; 
            if (hash.containsKey(des[i][0])) par = hash.get(des[i][0]);
            else {hash.put(des[i][0], new TreeNode(des[i][0])); par = hash.get(des[i][0]);}
            
            if (hash.containsKey(des[i][1])) child = hash.get(des[i][1]);
            else {hash.put(des[i][1], new TreeNode(des[i][1])); child = hash.get(des[i][1]);}
            if (des[i][2] == 1) par.left = child;
            else par.right = child;
            
        }
        
        HashSet<Integer> set = new HashSet<>(); 
        for (int i = 0; i < len; i++)set.add(des[i][1]);
        
        for (int i = 0; i < len; i++){
            if (!set.contains(des[i][0])) return hash.get(des[i][0]);
        }
        return new TreeNode(0);
        
    }
}