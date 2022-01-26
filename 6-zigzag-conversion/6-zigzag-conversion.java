class Solution {
    public String convert(String s, int numRows) {
        int[] arr = new int[s.length()];
        int t = 1; 
        arr[0] = t; 
        int mode = 1; 
        if (numRows == 1) return s; 
        int i1 = 1; 
        while ( i1 < s.length()){
            if (mode == 1){
                if (arr[i1 - 1] == numRows){
                    
                    mode = -1; 
                }
                else {
                    arr[i1] = arr[i1 - 1] + mode;
                    i1 +=1 ; 
                }
            }
            else {
                if (arr[i1 - 1] == 1){
                    
                    mode = 1; 
                }
                else {
                    arr[i1] = arr[i1 - 1] + mode;
                    i1 +=1 ; 
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        ArrayList<StringBuilder> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++){ans.add(new StringBuilder(""));}
        for (int i = 0; i < arr.length; i++){
            ans.get(arr[i] - 1).append(s.charAt(i));
        }
        StringBuilder fin = new StringBuilder();
        for (int i = 0; i < numRows; i++){
            fin.append(ans.get(i));
        }
        return fin.toString(); 
    }
}