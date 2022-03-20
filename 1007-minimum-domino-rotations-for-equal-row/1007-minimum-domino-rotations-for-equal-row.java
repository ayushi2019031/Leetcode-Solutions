class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int min = Integer.MAX_VALUE; 
        for (int i = 1; i <= 6; i++){
            int a1 =0; 
            int a2 = 0; 
            boolean poss = true;
            int ans1  = 0; 
            for (int j = 0; j < tops.length; j++){
                if (tops[j] != i ){
                    if (bottoms[j] == i) ans1 += 1;
                    else poss = false;
                }
            }
            
            int ans2  = 0; 
            for (int j = 0; j < tops.length; j++){
                if (bottoms[j] != i ){
                    if (tops[j] == i) ans2 += 1;
                    else poss = false;
                }
            }
            
            if (poss == true){
                min= Math.min(min, Math.min(ans1, ans2));
            }
        }
        if (min == Integer.MAX_VALUE) return -1; 
        return min;
    }
}