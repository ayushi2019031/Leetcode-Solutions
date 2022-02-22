/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q1 = new LinkedList<>();
        if (root == null) return root;
        q1.add(root);
        HashMap<Node, Integer> hash = new HashMap<>(); 
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        list.add(new ArrayList<>()); list.get(0).add(root);
        hash.put(root, 0);
        while (!q1.isEmpty()){
            Node k = q1.poll();
            if (k.left != null){hash.put(k.left, hash.get(k) + 1);
                if (list.size() <= hash.get(k.left)) list.add(new ArrayList<>());
                        list.get(hash.get(k.left)).add(k.left);
                            q1.add(k.left);
                               }
            
            if (k.right != null){hash.put(k.right, hash.get(k) + 1);
                if (list.size() <= hash.get(k.right)) list.add(new ArrayList<>());
                        list.get(hash.get(k.right)).add(k.right);
                                 q1.add(k.right);
                               }
        }
        for (int i = 0; i < list.size(); i++){
            for (int j = 0; j < list.get(i).size() - 1; j++){
                list.get(i).get(j).next= list.get(i).get(j + 1);
            }
        }
        return root;
    }
}