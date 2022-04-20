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
class BSTIterator {
    Stack<Integer> stack;
    TreeNode root ;
    public BSTIterator(TreeNode root) {
        this.stack  = new Stack<Integer>();
        this.root = root;
        help(this.root);
    }
    public void help(TreeNode kk){
        if (kk == null){return ;}
        help(kk.right);
        this.stack.push(kk.val);
        help(kk.left);
    }
    
    /** @return the next smallest number */
    public int next() {
        return stack.pop();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */