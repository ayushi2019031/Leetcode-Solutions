class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        HashMap<Character, Character> hash = new HashMap<>(); 
        int[][] matr = new int[256][256];
        for (char[] k: mappings){
            matr[k[0]][k[1]] = 1; 
        }
        
        for (int i = 0; i < 256; i++){matr[i][i] = 1;}
        for (int i = 0; i < s.length() - sub.length() + 1; i++){
            boolean isok = true;
            for (int j = 0; j < sub.length(); j++){
                if (matr[sub.charAt(j)][s.charAt(i + j)] == 0){isok = false; break;}
                else {}
            }
            if (isok){return isok;}
        }
        return false;
    }
}