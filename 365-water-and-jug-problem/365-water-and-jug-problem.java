class Solution {
    public boolean canMeasureWater(int jug1, int jug2, int targ) {
     int gcd_ = gcd(jug1, jug2);
        if (targ % gcd_ == 0 && (targ <= jug1 + jug2)) return true;
        return false;
    }
    public int gcd(int a, int b){
        if (a == 0) return b;
        return gcd(b% a, a);
    }
}