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
    public TreeNode convertBST(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        helper(root, q); int k  =0;
        while (q.size() > 0){
        TreeNode ref = q.poll();
        ref.val += k;
            k = ref.val;
        }
        return root;
    }
    public void helper(TreeNode root, Queue<TreeNode> q){
        if (root == null){return ;}
        helper(root.right, q);
        q.add(root);
        helper(root.left, q);
    }
}