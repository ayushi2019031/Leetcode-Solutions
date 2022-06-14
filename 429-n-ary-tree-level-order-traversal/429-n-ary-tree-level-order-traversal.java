/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<List<Integer>> ans = new ArrayList<>(); 
    public List<List<Integer>> levelOrder(Node root) {
        fun(root, 0);
        return ans;
    }
    public void fun(Node root, int level){
        if (root == null) return;
        if (ans.size() <= level){
            ans.add(new ArrayList<Integer>());
        }
        ans.get(level).add(root.val);
        for (Node k: root.children){
            fun(k, level + 1);
        }
    }
    
}