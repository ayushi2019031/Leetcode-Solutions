class Solution{
public int countPairs(TreeNode root, int distance) {
        if(root==null){
            return 0;
        }
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        List<TreeNode> leaves = new ArrayList<>();
        dfs(parentMap, leaves, root, null);
        int total=0;
        for(TreeNode node:leaves){
            Set<TreeNode> seen= new HashSet<>();
            total+=dfs(seen, parentMap, node, 0, distance);
        }
        return total/2;
    }
    
private int dfs(Set<TreeNode> seen,Map<TreeNode, TreeNode> parentMap, TreeNode node,int steps, int distance){
        if(steps>distance){
                return 0;
        }
        if(seen.contains(node)){
            return 0;
        }
        if(node.left==null && node.right==null && steps<=distance && steps!=0 ){
                return 1;
        }
        int total=0;
        seen.add(node);
        if(parentMap.get(node)!=null){
            total+=dfs(seen, parentMap,parentMap.get(node),steps+1,distance);  
        }
        if(node.left!=null){
            total+=dfs(seen, parentMap, node.left,steps+1,distance);  
        }
        if(node.right!=null){
            total+=dfs(seen, parentMap, node.right,steps+1,distance);  
        }
        return total;
    }
    
    
private void dfs(Map<TreeNode, TreeNode> parentMap,List<TreeNode> leaves, TreeNode root , TreeNode parent){
        if(root==null){
            return;
        }
        parentMap.put(root, parent);
        if(root.left==null && root.right==null){
            leaves.add(root);
            return;
        }
        dfs(parentMap, leaves, root.left, root);
        dfs(parentMap, leaves, root.right, root);
        
}
}