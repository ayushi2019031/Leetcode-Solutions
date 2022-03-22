class Solution {
    public int countSegments(String s) {
        int i = 0; int j = 0; int n = s.length(); 
        int ans = 0; 
        while (i < n){
            j = i; 
            while (j < n && s.charAt(j) != ' '){
                j += 1;
            }
        
            if (j == i){i += 1;}
            else {ans += 1; i = j;}
        }
        return ans;
    }
}