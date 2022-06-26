class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int i = 0; int j = 0; int n = cardPoints.length; int sum = 0; int min;
        while (j != n - k){
            sum += cardPoints[j]; j++;
            }
        min = sum;
        while (j != n){
            sum -= cardPoints[i];
            i += 1;
            sum += cardPoints[j]; j += 1;
            if (sum < min){min = sum;}
            
        } int t = 0;
        for (int  u = 0; u < n; u++){
            
            t += cardPoints[u];
        }
        
        
        return t - min;
    }
}