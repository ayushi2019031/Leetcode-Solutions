class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length];
        Arrays.fill(dp, -1);
        return fun(dp, days, costs, 0);
    }
    public int fun(int[] dp, int[] days, int[] costs, int pos){
        if (pos >= dp.length) return 0; 
        if (dp[pos] != -1){return dp[pos];}
        
        int ans = Integer.MAX_VALUE;
        // for 1 day = costs[0]
        ans = Math.min(ans, costs[0] + fun(dp, days, costs, pos + 1));
        
        // for 7 days = costs[1]
        int r = days[pos] + 7; 
        int ss = pos + 1; 
        while (ss < dp.length && days[ss] < r){ss += 1;}
        ans = Math.min(ans, costs[1] + fun(dp, days, costs,ss));
        
        // for 7 days = costs[1]
        r = days[pos] + 30; 
        ss = pos + 1; 
        while (ss < dp.length && days[ss] < r){ss += 1;}
        ans = Math.min(ans, costs[2] + fun(dp, days, costs,ss));
        
        dp[pos] = ans;
        
        return dp[pos];
    }
}