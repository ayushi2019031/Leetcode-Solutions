class Solution {
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int ans = 0; 
        int[] arryo = new int[12];
        for (int i = 0;  i <= (1 << 12); i++){
            // System.out.println(i);
            int aj = 0; int arrs = numArrows; int[] poss = new int[aliceArrows.length]; 
            for (int j = 11; j>= 0; j--){
                if ((i & (1 << j)) != 0){
                    if (aliceArrows[j] + 1 <= arrs ){
                        arrs -= (aliceArrows[j] + 1);
                        poss[j] = aliceArrows[j] + 1; 
                        aj += (j); 
                    }
                }
            }
            if (aj > ans){
            ans = Math.max(ans, aj);
            arryo = poss;
            }
        }
        int kk = 0; 
        for (int i= 0; i < 12; i++){kk += arryo[i];}
        if (kk < numArrows){arryo[0] += -(kk - numArrows);}
        System.out.println(ans);
        return arryo;
    }
}