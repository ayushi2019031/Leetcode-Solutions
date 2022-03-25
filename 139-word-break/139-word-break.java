class Solution {
    int[] dp; 
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return fun(s, wordDict, 0);
        
    }
    public boolean fun(String s, List<String> wordDict, int pos){
        if (pos >= s.length()){return true;}
        if (dp[pos] != -1) {
            if (dp[pos] == 1) return true;
            else return false;
        }
        boolean f = false;
        for (int i = pos;i < s.length(); i++){
            if (present(s.substring(pos, i + 1), wordDict)){
                f = f | fun(s, wordDict, i + 1);
                if (f) dp[pos] = 1;
                if (f) return f; 
            }
        }
    dp[pos] = 0;
    return false;
    }
    public boolean present(String s, List<String> words){
        for (String k: words){
            if (s.equals(k)) return true;
        }
        return false;
    }
}