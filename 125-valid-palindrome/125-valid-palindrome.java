class Solution {
    public boolean isPalindrome(String s) {
        
        s = s.replaceAll("[^0-9a-zA-Z]+", "");
        s = s.toLowerCase();
        return isPal(s);
    }
    public boolean isPal(String s){
        if (s.length() <= 1) return true;
        return s.charAt(0) == s.charAt(s.length() - 1) && isPal(s.substring(1, s.length() - 1));
    }
}