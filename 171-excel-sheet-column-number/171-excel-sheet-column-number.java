class Solution {
    public int titleToNumber(String s) {
       int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--){
          
            ans +=Math.pow(26, s.length() -i - 1)* (s.charAt(i) - 64);
            //ans += (int) (s.charAt(i) - 65);
        } return ans  ; 
    }
}