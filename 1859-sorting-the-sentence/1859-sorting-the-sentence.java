class Solution {
    public String sortSentence(String s) {
        String[] arr = s.split(" ", s.length()); 
        int n = arr.length; 
        String[] ans = new String[n];
        
        for (int i = 0; i < n; i++){
            String k = arr[i]; 
            int ind = Integer.parseInt(k.substring( k.length() - 1, k.length())); 
            String jj = k.substring(0, k.length() - 1); 
            ans[ind -1] = jj; 
        }
        StringBuilder aj = new StringBuilder("");
        for (int i = 0; i < n; i++){
            aj.append(ans[i]); 
            aj.append(" "); 
        }
        String op = aj.toString(); 
        op = op.substring(0, op.length() - 1); 
        return op; 
    }
}