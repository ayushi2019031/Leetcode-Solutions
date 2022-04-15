class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char[] a1 = s1.toCharArray(); 
        char[] a2 = s2.toCharArray(); 
        Arrays.sort(a1); Arrays.sort(a2);
        int n = a1.length; 
        boolean f1 = true;
        for (int i = 0; i < n; i++){
            if (a2[i] < a1[i]) f1 =  false;
        }
        
        boolean f2 = true;
        for (int i = 0; i < n; i++){
            if (a1[i] < a2[i]) f2 =  false;
        }
        return f2 || f1; 
    }
}