class Solution{
public String fractionToDecimal(int numerator, int denominator) {
    StringBuilder sb = new StringBuilder();
    
    if (numerator == 0) return "0";
    
    sb.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
    
    
    long num = Math.abs((long) numerator), den = Math.abs((long) denominator);
    sb.append(num / den);
    
    num %= den;
    
    if(num != 0) {
        sb.append(".");

        Map<Long, Integer> lastIndex = new HashMap<>();
    
        while(num != 0 && !lastIndex.containsKey(num)) {
            lastIndex.put(num, sb.length());
            num *= 10;
            sb.append(num / den);
            num %= den;
        }
        
        if(num != 0) {
            sb.insert(lastIndex.get(num), "(");
            sb.append(")");
        }
    }
    
    return sb.toString();
}
}