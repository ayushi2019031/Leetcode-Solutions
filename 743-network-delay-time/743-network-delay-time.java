class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
       ArrayList<Pair<Integer, Integer>>[] adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<Pair<Integer, Integer>>(); 
        
        for (int[] time: times){
            adj[time[0]].add(new Pair<Integer, Integer>(time[1], time[2]));
            // adj[time[1]].add(new Pair<Integer, Integer>(time[0], time[2]));
        }
        
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>(){
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2){
                return o1.getValue() - o2.getValue(); 
            }
        }); 
        Integer[] distance = new Integer[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        pq.add(new Pair<Integer, Integer>(k, 0));
        distance[k] = 0; 
        
        while(!pq.isEmpty()){
            Pair<Integer, Integer> curr = pq.poll(); 
            if (distance[curr.getKey()] < curr.getValue()) continue;
            
            for (Pair<Integer, Integer> aj: adj[curr.getKey()]){
                int f = aj.getKey(); int s = aj.getValue(); 
                if (s + curr.getValue() < distance[f]){
                    distance[f] = s + curr.getValue(); 
                    pq.add(new Pair<Integer, Integer>(f, distance[f])); 
                }
            }
        }
        int ans = 0; 
        for (int i = 1; i <= n; i++){
            ans = Math.max(ans, distance[i]);
        }
        if (ans == Integer.MAX_VALUE) return -1; 
        return ans; 
    }
}