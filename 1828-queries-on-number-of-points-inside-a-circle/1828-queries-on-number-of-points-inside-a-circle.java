class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] arr = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++){
            int ans =0; 
            for (int j = 0; j < points.length; j++){
                double dist = (points[j][0] - queries[i][0])*(points[j][0] - queries[i][0]) + (points[j][1] - queries[i][1])*(points[j][1] - queries[i][1]); 
                dist = Math.sqrt(dist); 
                if (dist <= queries[i][2]){
                    ans += 1; 
                }
            }
            arr[i] = ans; 
        }
        return arr; 
    }
}