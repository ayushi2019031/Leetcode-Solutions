class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        for (int i = 0; i < n; i++){
            capacity[i] -= rocks[i];
        }
        Arrays.sort(capacity);
        int i = 0; 
        while (additionalRocks > 0 && i <n){
            if (capacity[i] <= additionalRocks ){
                additionalRocks -= capacity[i];
                capacity[i] = 0; 
            }
            i += 1; 
        }
        int ind = -1; 
        for (int j = 0; j < rocks.length;j++){
            if (capacity[j] == 0){ind = j;}
        }
        return ind + 1; 
    }
}