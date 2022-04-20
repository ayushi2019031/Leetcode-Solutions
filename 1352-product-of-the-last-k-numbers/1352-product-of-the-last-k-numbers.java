class ProductOfNumbers {
    ArrayList<Integer> list;
    int prev;
    
    public ProductOfNumbers() {
        list = new ArrayList<>();
        prev = 1;
    }
    
    public void add(int num) {
        if(num == 0){
            list = new ArrayList<>();
            prev = 1;
        }
        else{
            prev = prev * num;
            list.add(prev);
        }
    }
    
    public int getProduct(int k) {
        int n = list.size();
        if(k == n){
            return list.get(n-1);
        }
        else if(k > n){
            return 0;
        }
        else{
            return list.get(n-1) / list.get(n-k-1);
        }
    }
}