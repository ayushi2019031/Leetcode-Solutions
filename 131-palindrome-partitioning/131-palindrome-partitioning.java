class Solution {
    char[] arr; 
    int n; 
    String s; 
    int[][] dp; 
    
    public List<List<String>> partition(String s) {
            arr = s.toCharArray();
        n = arr.length;
        this.s = s; 
        dp = new int[n][n];
        for (int i =0; i < n; i++){
            for (int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
         n = arr.length;
        List<List<String>> fin_ans = new ArrayList<>(); 
        fun(fin_ans, new ArrayList<String>(), 0);
        return fin_ans;
    }
    public void fun(List<List<String>> final_ans, ArrayList<String> list, int pos){
        // System.out.println(pos);
        if (pos >= n){
            final_ans.add(new ArrayList<>(list));
            return;
        } 
        
        for (int i = pos; i < n ; i++){;
            
            if (isPalindrome(pos, i) == 1){
                list.add(s.substring(pos, i + 1));
                fun(final_ans, list, i + 1);
                list.remove(list.size() - 1); 
            }
        }
    }
    
    public int isPalindrome(int s, int e){
        // System.out.println(s + " " + e);
        if (s > e || s == e) return 1; 
        if (dp[s][e] != -1) return dp[s][e];
        
        if (arr[s] == arr[e]){dp[s][e]  = isPalindrome(s + 1, e -1 ); }
        else dp[s][e] = 0; 
        return dp[s][e];
    }
    
}