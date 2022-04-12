class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length; 
        int[] arr1 = new int[n];
        arr1[0] = values[0];
        for (int i = 1; i < n; i++){
            arr1[i] = Math.max(arr1[i - 1], values[i] + i);
        }
        
        int[] arr2 = new int[n];
        arr2[n - 1] = values[n - 1] - (n - 1);
        
        
        for (int i = n - 2; i >= 0; i--){
         arr2[i] = Math.max(values[i] - i, arr2[i + 1]);   
        }
        int max = Integer.MIN_VALUE; 
        for (int i = 0; i < n - 1; i++){
            max = Math.max(max, arr1[i] + arr2[i + 1]);
        }
        
        return max; 
    }
}