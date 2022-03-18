class Solution {
    String[] dp; 
    public String MAX(String s1, String s2){
        if (s1.length() == s2.length()) {
            for (int i = 0; i < s1.length(); i++){
                if (s1.charAt(i) > s2.charAt(i)) return s1; 
                else if (s1.charAt(i) < s2.charAt(i)) return s2; 
            }
            return s1; 
        }
        else if (s1.length() > s2.length()){
            return s1; 
        }
        else{
            return s2; 
        }
    }
    public String largestNumber(int[] cost, int target) {
        dp= new String[target + 1];
        
        String jj =  fun(cost, target);
        System.out.println(Arrays.toString(dp));
        if (jj.equals("") || jj.equals("#")) return "0";
        int aj = 0; 
        for (char c: jj.toCharArray()){
            aj += cost[c - '0' - 1];
        }
        if (aj == target) return jj;
        return "0";
    }
    public String fun(int[] cost, int target){
        
        if (target < 0 ) return "#";
        if (target == 0) return "";
        if (target > 0){
            boolean poss = false;
            for (int i = 0; i < cost.length; i++){
                if (cost[i] <= target) poss = true;
            }
            if (!poss) return "#";
            
        }
        if (dp[target] != null) return dp[target];
        String max = ""; 
        for (int i = 9; i >= 1; i--){
        
            String k = fun(cost, target - cost[i - 1]);
            
            int check = 0; 
            if (!k.equals("#")){
            for (char gg: k.toCharArray()){
                check += cost[gg - '0' - 1] ;
            }
            }
            // System.out.println(strb.toString());
            if (!k.equals("#") && check == target - cost[i - 1]){
              
                StringBuilder kk = new StringBuilder(Integer.toString(i));
                kk.append(k);
                int b = target -cost[i - 1];
                // System.out.println("Whoosh: " + kk.toString() + " " + b);
                max = MAX(max, kk.toString());
                
            }
        }
        dp[target] = max;
        
        return max; 
    }
}