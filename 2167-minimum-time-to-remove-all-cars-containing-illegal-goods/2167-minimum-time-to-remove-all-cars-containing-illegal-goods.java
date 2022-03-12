class Solution {
    public int minimumTime(String s) {
        ArrayList<Integer> list = new ArrayList<>(); 
        
        int len = s.length(); 
        for (int i = 0; i < len ; i++){
            if (s.charAt(i) == '1') list.add(i);
        }
        int n = list.size(); 
        if (n == 0) return 0; 
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        
        arr1[0] = Math.min(2, list.get(0) + 1) ;
        // System.out.println(list);
        
        arr2[n - 1] = Math.min(2, len - list.get(n - 1)); 
        for (int i = 1; i < n; i++){
            arr1[i] = Math.min(list.get(i) + 1, arr1[i - 1] + 2);
        }
        
        for (int i = n - 2; i >= 0; i--){
            arr2[i] = Math.min(len - list.get(i) , arr2[i + 1] + 2);
        }
        
        int ans = Math.min(arr1[n - 1], arr2[0]);


        for (int i = 0; i < n - 1; i++){
            ans = Math.min(ans, arr1[i] + arr2[i + 1]);
        }
        // System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        return ans; 
    }
}