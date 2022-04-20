class Solution {
    public int countPaths(int n, int[][] roads) {
        int[][] map = new int[n][n];
        for (int[] r : roads) {
            map[r[0]][r[1]] = r[2];
            map[r[1]][r[0]] = r[2];
        }
        // Dijkstra to find the shortest time. 
        int MOD = 1_000_000_007;
        int[] dist = new int[n];
        int[] count = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        count[0] = 1;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            if (p[1] > dist[p[0]]) continue;
            if (p[0] == n-1) break;
            int cur = p[0];
            for (int i = 0; i < n; i++) {
                if (map[cur][i] == 0) continue;
                int cost = p[1] + map[cur][i];
                // only update when we find a path that takes same or less time.
                if (cost <= dist[i]) {
                    if (cost < dist[i]) {
                        count[i] = 0;
                        dist[i] = cost;
                        pq.offer(new int[]{i, cost});
                    }
                    count[i] = (count[i] + count[cur]) % MOD;
                }
            }
        }
        return count[n-1];
    }
}