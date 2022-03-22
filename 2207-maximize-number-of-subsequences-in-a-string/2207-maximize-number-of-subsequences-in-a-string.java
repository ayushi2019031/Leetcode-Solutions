class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        int n = text.length();
        long[] prefix = new long[n];
        long[] suffix = new long[n];
        
        if (text.charAt(0) == pattern.charAt(0)){prefix[0] = 1;}
        if (text.charAt(n - 1) == pattern.charAt(1)){suffix[n - 1] = 1;}
        
        for (int i = 1; i < n; i++){
            prefix[i]= prefix[i - 1]; 
            if (text.charAt(i) == pattern.charAt(0)) prefix[i] += 1;
        }
        
        for (int i = n - 2; i >= 0; i--){
            suffix[i]= suffix[i + 1]; 
            if (text.charAt(i) == pattern.charAt(1)) suffix[i] += 1;
        }
        long ans = 0; 
        
        for (int i = 0; i < n - 1; i++){
            if (text.charAt(i) == pattern.charAt(0))ans += suffix[i + 1];
        }
        int s1 = n - 1; 
        
        ans = Math.max(ans, Math.max(ans + suffix[0], ans + prefix[n - 1]));

        return ans; 
        
        
    }
}