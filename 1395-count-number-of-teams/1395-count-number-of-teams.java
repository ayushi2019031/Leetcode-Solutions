class Solution{
public int numTeams(int[] rating) {
	int[] dp = new int[rating.length];
	int[] dp2 = new int[rating.length];
	int ans = 0;
	for(int i = 1; i < rating.length; i++){
		for(int j = i - 1; j >= 0; j--){
			if(rating[j] < rating[i]){
				dp[i]++;
				ans += dp[j];
			} 
			if(rating[j] > rating[i]){
				dp2[i]++;
				ans += dp2[j];
			}
		}
	}
	return ans;
}
}