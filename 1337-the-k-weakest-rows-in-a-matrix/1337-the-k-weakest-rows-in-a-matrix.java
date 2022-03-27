class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length; 
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++){
            int ans = 0; 
            for (int j = 0; j < mat[i].length; j++){
                ans += mat[i][j];
            }
            nodes[i] = new Node(i, ans); 
        }
        Arrays.sort(nodes, new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                int u1 = n1.n_ones - n2.n_ones;
                if (u1 == 0) return n1.index - n2.index; 
                return u1; 
            }
        });
        
        int[] ans = new int[k];
        for (int i= 0; i < k; i++){
            ans[i] = nodes[i].index; 
        }
        return ans;
    }
}
class Node{
    int index; int n_ones; 
    public Node(int index, int n_ones){
        this.index = index; this.n_ones = n_ones;
    }
}