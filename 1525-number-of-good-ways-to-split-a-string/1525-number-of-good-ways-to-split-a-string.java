class Solution {
    public int numSplits(String s) {
        int n = s.length(); 
        HashSet<Integer>[] arr1= new HashSet[n];
        HashSet<Integer>[] arr2= new HashSet[n];
        
        for (int i = 0; i < n; i++){arr1[i] = new HashSet<>(); arr2[i] = new HashSet<>();}
        
        arr1[0].add(s.charAt(0) - 'a');
        for (int i = 1; i < n; i++){
            int num = s.charAt(i) - 'a'; 
            arr1[i].addAll(arr1[i - 1]); 
            arr1[i].add(num); 
        }
        arr2[n - 1].add(s.charAt(n - 1) - 'a');
        for (int i = n - 2; i >= 0; i--){
            int num = s.charAt(i) - 'a'; 
            arr2[i].addAll(arr2[i + 1]); 
            arr2[i].add(num); 
        }
        int ans = 0; 
        for (int i = 1; i < n; i++){
            if (arr1[i -1].size() == arr2[i].size()){
                ans += 1;
            }
        }
        return ans; 
    }
}