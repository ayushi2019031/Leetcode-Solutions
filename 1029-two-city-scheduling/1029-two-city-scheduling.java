class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n  = costs.length;
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            public int compare(Node o1, Node o2){
                return o1.diff - o2.diff;
            }
        }) ;
        
        for (int i = 0; i < n; i++) pq.add(new Node(costs[i][0] - costs[i][1], i));
        int ans = 0; 
        int num_a= 0; 
        while (num_a < n/2){
            ans += costs[pq.poll().ind][0];
            num_a += 1; 
        }
        while (!pq.isEmpty()){
            ans += costs[pq.poll().ind][1];
        }
        return ans;
    }
}
class Node{
    int diff; int ind; 
    public Node(int diff, int ind){
        this.diff = diff; 
        this.ind = ind; 
    }
}