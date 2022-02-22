/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> hash = new HashMap<>(); 
    public Node cloneGraph(Node node) {
        if (node == null) return null;
       Node startingNode = new Node();
        startingNode.val = node.val;
        hash.put(node, startingNode);
        startingNode.neighbors = new ArrayList<>();
        
        for (Node k: node.neighbors){
           if (!hash.containsKey(k)) cloneGraph(k);
            startingNode.neighbors.add(hash.get(k));
        }
        return startingNode;
    }
}