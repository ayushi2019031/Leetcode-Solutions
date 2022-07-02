class Solution {
    public int lengthOfLongestSubstring(String s) {
         int i = 0; int j = 0; 
        HashMap<Character, Integer> hash = new HashMap<>();
        int n = s.length(); 
        int ans = 0; 
        
            while (j < n){
                char c = s.charAt(j);
                if (!hash.containsKey(c)){
                    hash.put(c, 0);
                }
                if (hash.get(c) > 0){
                    
                    while (hash.get(c) > 0){
                        char d = s.charAt(i);
                        
                        hash.put(d, hash.get(d) - 1);
                        i += 1;
                        ans = Math.max(ans, j - i);
                    }
                }
                else {
                    hash.put(c, 1);
                    ans = Math.max(ans, j - i + 1);
                    j += 1; 
                }
            }
        
        return ans; 
    }
}