class Solution {
    public int countVowelStrings(int n) {
        return fun(n, 0); 
    }
    
    public int fun(int n, int curr_lett){
        if (curr_lett >= 5){return 0; }
        if (n == 0) return 0; 
        if (n == 1) return 5 - curr_lett; 
        int ans = 0; 
        for (int i = curr_lett; i < 5; i++){
            ans += fun(n - 1, i);
        }
        return ans; 
    }
}