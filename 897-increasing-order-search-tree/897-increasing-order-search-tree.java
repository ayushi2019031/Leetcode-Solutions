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
    public TreeNode increasingBST(TreeNode root) {
    ArrayList<TreeNode> list = new ArrayList<TreeNode>();
    InOrder(list , root);
    for (int i = 0; i < list.size() - 1; i++){
        list.get(i).left = null;
        list.get(i).right = list.get(i + 1);        
}
        list.get(list.size() - 1).left = null;
        list.get(list.size() - 1).right = null;
        return list.get(0);
    }
    public void InOrder(ArrayList<TreeNode> list, TreeNode root){
        if (root.left != null){InOrder(list, root.left);}
        list.add(root);
        if (root.right != null){InOrder(list, root.right);}
    }
}