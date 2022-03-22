class Solution {
    public String licenseKeyFormatting(String s_, int k) {
        String s = s_.toUpperCase();
        int n = s.length(); 
        StringBuilder strb = new StringBuilder();
        
        for (int i = 0; i < n; i++){
            if (s.charAt(i) != '-'){
                strb.append(s.charAt(i));
            }
        }
        
        int len = strb.toString().length(); 
        if (len == 0) return "";
        int sk = len % k;
        StringBuilder ans = new StringBuilder(); 
        int start = 0; 
        if (sk != 0){
         ans.append(strb.toString().substring(0, sk));
            ans.append("-");
            start = sk;
        }
        while (start < len){
            ans.append(strb.toString().substring(start, start + k));
            ans.append("-");
            start = start + k; 
        }
        return ans.toString().substring(0, ans.toString().length() - 1); 
        
    }
}