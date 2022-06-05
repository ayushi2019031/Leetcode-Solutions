class Cashier {
    int t = 0; 
    int n; 
    int discount;
    int[] products; 
    int[] prices;
    HashMap<Integer, Integer> hash = new HashMap<>(); 
    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n; 
        this.discount = discount;
        this.products  = products;
        this.prices = prices;
        for (int i = 0; i < products.length; i++){
            hash.put(products[i], prices[i]);
        }
    }
    
    public double getBill(int[] product, int[] amount) {
        t += 1;
        int sum = 0; 
        for (int i = 0; i < product.length;i++){
            sum += amount[i]*hash.get(product[i]);
        }
        if (t % n == 0){
            return (double) sum*((double)(100 - discount)/(double)100);
        }
        return (double) sum; 
    }
}

/**
 * Your Cashier object will be instantiated and called as such:
 * Cashier obj = new Cashier(n, discount, products, prices);
 * double param_1 = obj.getBill(product,amount);
 */