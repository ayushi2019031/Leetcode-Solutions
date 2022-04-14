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
    public TreeNode balanceBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>(); 
        TreeNode curr = root; 
        List<TreeNode> list = new ArrayList<>(); 
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr); curr = curr.left;
            }
            curr = stack.pop(); 
            list.add(curr);
            curr = curr.right; 
        }
        
        TreeNode[] arr= new TreeNode[list.size()];
        
        for (int i = 0; i < list.size(); i++){
            arr[i] = list.get(i); 
            arr[i].left = null; arr[i].right = null;
        }
        
        return fun(arr, 0, list.size() - 1); 
    }
    public TreeNode fun(TreeNode[] arr, int s, int e){
        if (s == e) return arr[s];
        if (s > e) return null;
        
        int mid = s + (e - s)/2;
        TreeNode root = arr[mid];
        root.left = fun(arr, s, mid - 1); 
        root.right = fun(arr, mid + 1, e); 
        return root; 
    }
}