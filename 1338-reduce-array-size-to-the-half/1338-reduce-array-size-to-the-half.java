class Solution {
    public int minSetSize(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>(); 
        Arrays.sort(arr);
        int n = arr.length; 
        int i = 0; int j = 0;
        
        while (i < n){
            j = i; 
            while (j < n && arr[i] == arr[j]){j += 1; }
            list.add(j - i); 
            i = j; 
        }
        Collections.sort(list); Collections.reverse(list); 
        int ans = 0; 
        int rr = 0;
         
        for (int aj = 0; aj < list.size(); aj++){
            rr += list.get(aj); 
            ans += 1; 
            if (rr >= (n)/2){
                return ans; 
            }
        }
        return ans; 
    }
}