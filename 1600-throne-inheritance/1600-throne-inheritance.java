class Node{
    ArrayList<Node> children;  
    String name; 
    public Node(String name){
        this.name = name; 
        this.children = new ArrayList<>();
    }
}
class ThroneInheritance {
    Node king; 
    HashMap<String, Node> hash = new HashMap<>(); 
    public ThroneInheritance(String kingName) {
        king = new Node(kingName);
        hash.put(kingName, king);
    }
    
    public void birth(String parentName, String childName) {
        Node aj = new Node(childName);
        Node par = hash.get(parentName);
        par.children.add(aj);
        hash.put(childName, aj);
    }
    
    public void death(String name) {
        hash.remove(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> list = new ArrayList<>();
        preorder(king, list);
        return list;
    }
    public void preorder(Node king, List<String> list){
        
        if (hash.containsKey(king.name))
        list.add(king.name);
        for (Node k: king.children){
        
            preorder(k, list);
            
        }
        
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */