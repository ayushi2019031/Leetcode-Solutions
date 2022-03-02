class Solution{
public double largestSumOfAverages(int[] nums, int k) {
        Double[][] memo = new Double[nums.length+1][k+1];
        return recur(nums, 0, k, memo);
    }
    
    public double recur(int[] a, int s, int k, Double[][] memo){
        if (s > a.length - 1) return 0;
		
		// ignore this combination of subarrays , since the end is not reached that means we have not utilized the arrays fully
        if (k == 0 && s < a.length) return -1000000;
        if (memo[s][k] != null) return memo[s][k];

        double sum = 0, sum2 = 0;
        for (int i = s; i < a.length; i++) {
            sum2 = sum2 + a[i];
            double avg = sum2/(i-s+1);
            double value = avg + recur(a, i + 1, k - 1, memo);

            sum = Math.max(sum, value);
        }
        return memo[s][k] = sum;
    }
}