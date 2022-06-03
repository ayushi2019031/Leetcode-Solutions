class Solution {
    public int maxProduct(String[] words) {
    int n = words.length; 
     int[][] dp = new int[n][26]; 
    
        for (int i = 0; i < n; i++){
            String word = words[i];
            for (char c: word.toCharArray()){
                dp[i][c - 'a'] = 1; 
            }
        }
        
        int ans = 0; 
        
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                boolean f = true;
                for (int k = 0 ;k < 26; k++){
                    if (dp[i][k] == 1 && dp[j][k] == 1){
                        f = false;
                    }
                }
                if (f){
                    ans = Math.max(ans, words[i].length()*words[j].length());
                }
            }
        }
        return ans; 
    }
}