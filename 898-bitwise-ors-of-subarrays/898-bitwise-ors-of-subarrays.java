class Solution {
    public int subarrayBitwiseORs(int[] arr) {
       
        HashSet<Integer> res=new HashSet();
        HashSet<Integer> prev=new HashSet();
        
        for(int i=0;i<arr.length;i++){
           
            HashSet<Integer> temp=new HashSet();
            temp.add(arr[i]);
            
            
            for(int num:prev){
                temp.add(num  | arr[i]);
            }
            
            for(int num:temp){
                res.add(num);
            }
            prev=temp;
        }
        
        return res.size();
    }
}