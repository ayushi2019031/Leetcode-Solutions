class Solution {
    // [4, 2, 3, 1] -- > [3]
    // [1, 3, 2, 4]  --> [4]
    // [3, 1, 2, 4] --> [2]
    // [2, 1, 3, 4] --> []
    public int getIndex(int[] arr, int find, int e){
        for (int i = e ; i >= 0; i--){
            if (arr[i] == find) return i; 
        }
        return -1; 
    }
    public void reverseArray(int[] arr, int s, int e){
        int i = s; int j = e; 
        while (i < j){
            int temp = arr[i]; 
            arr[i] = arr[j]; 
            arr[j] = temp; 
            i += 1; j -= 1; 
        }
        
    }
    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length; 
        int[] arr2 = new int[n];
        for (int i =0 ; i < n; i++) arr2[i] = arr[i]; 
        Arrays.sort(arr2); 
        List<Integer> list = new ArrayList<>(); 
        for (int i = n - 1; i >=  0; i--){
            if (arr[i] != arr2[i]){
                int ind = getIndex(arr, arr2[i], i - 1);
                list.add(ind + 1); 
                reverseArray(arr, 0, ind); 
                if (ind < i) {
                    // list.add(ind + 1); 
list.add(i + 1); 
                              reverseArray(arr, 0, i); 
            }
                
            }
        }
        
        return list; 
    }
    
}