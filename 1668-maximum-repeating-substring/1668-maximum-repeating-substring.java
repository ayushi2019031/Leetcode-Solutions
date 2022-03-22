class Solution {
    public int maxRepeating(String sequence, String word) {
        int i= 0; int j = 0; 
        int n1 = sequence.length(); int n2 = word.length(); 
        int max = 0; 
        while (i < n1){
            j = i; 
            int k = 0; 
            while (j < n1 && sequence.charAt(j) == word.charAt(k % n2)){
                j += 1;
                k += 1; 
            }
            System.out.println(k); 
            max = Math.max(max, k/n2);
           i += 1;  
        }
        System.out.println("---------------");
        return max; 
    }
}