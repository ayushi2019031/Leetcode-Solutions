class Solution {
    public boolean detectCapitalUse(String word) {
        boolean f1 = false; 
        boolean f2 = false; 
        boolean f3 = false; 
        for (int i = 1; i < word.length(); i++){
            if (Character.isUpperCase(word.charAt(i))){f1 = true;}
            else {
                if (f1 == true){return false;}
                else break;
            }
        }
        if (f1 == true){
            if (Character.isUpperCase(word.charAt(0))) return true;
            return false;
        }
        for (int i = 1; i < word.length(); i++){
            if (Character.isLowerCase(word.charAt(i))){f2 = true;}
            else {
                return false;
            }
        }
        return true;
    }
}