class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
     int[] destination = new int[1001]; 
        
        for (int[] trip: trips){
            destination[trip[1]] +=trip[0];
            destination[trip[2]] -= trip[0];
        }
        
        for (int i = 1; i <= 1000; i++){
            destination[i] = destination[i - 1] + destination[i];
            if (destination[i] < 0) destination[i] = 0; 
        }
        for (int i = 0; i <= 1000; i++){
            if (destination[i] > capacity) return false;
        }
        return true;
    }
}