class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build the graph 
        Map<Integer, List<int[]>> graph = new HashMap<>();
        buildGraph(flights, graph);
        
        // Maintain a PQ to fetch the min cost with max K stops. PQ will have 3 items - 
        //  1. node - The node to visit
        //  2. cost - Cost to visit the node
        //  3. stops - Remaining number of stops to visit destination
        // The PQ is maintained as a 
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        minHeap.add(new int[] {src, 0, 0});
        
        // Maintains the minimum number of stops from a particular city. We'll use this information to optimize our processing
        HashMap<Integer, Integer> seen = new HashMap<>();

        // Traversing until destination city is reached or our minHeap has exhausted
        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int city = curr[0];
            int cost = curr[1];
            int stops = curr[2];
        
            // If a city is not visited earlier OR the number of stops is lesser than previous visit, then only we'll explore this path
			// or else we'll go to the next node in the minHeap
            // Because we are always choosing cheapest route, so it doesn't make sense to re-calculate the min cost again for same or higher number of stops. 
			// We will only calculate if the number of stops this time is lesser than the previous visit
            if(!seen.containsKey(city) || stops < seen.get(city))
                seen.put(city, stops);
            else
                continue;
            
			// If the current city is the destination then definitely the cost calculated till now is the minimum cost, hence we return that cost
            if(city == dst)
                return cost;
            
			// If the number of stops has exceeded k OR there are no adjacent cities of the current city then we poll the next node out of the minHeap
            if(stops > k || !graph.containsKey(city))
                continue;
            
			// Iterate through all the adjacent cities of the current city
            for(int[] adjCity : graph.get(city)){
                minHeap.add(new int[]{adjCity[0], cost + adjCity[1], stops+1});
            }
        }
        return -1;
    }
    
    void buildGraph(int[][] flights, Map<Integer, List<int[]>> graph){
        for(int[] flight : flights){
            graph.putIfAbsent(flight[0], new ArrayList<>());
            graph.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
    }
}