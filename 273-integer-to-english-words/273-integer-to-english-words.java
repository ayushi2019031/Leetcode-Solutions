class Solution {
    HashMap<Integer, String> tens = new HashMap<>(); 
    HashMap<Integer, String> ones = new HashMap<>();
    HashMap<Integer, String> positions = new HashMap<>(); 
    
    public String numberToWords(int num) {
        tens.put( 1, "Ten");
    tens.put(2, "Twenty");
    tens.put(3, "Thirty");
    tens.put(4, "Forty");
    tens.put(5, "Fifty");
    tens.put(6, "Sixty");
    tens.put(7, "Seventy");
    tens.put(8, "Eighty");
    tens.put(9, "Ninety");
    
    
    ones.put(1, "One");
    ones.put(2, "Two");
    ones.put(3, "Three");
    ones.put(4, "Four");
    ones.put(5, "Five");
    ones.put(6, "Six");
    ones.put(7, "Seven");
    ones.put(8, "Eight");
    ones.put(9, "Nine");
    
    positions.put(1, "Thousand");
    positions.put(2, "Million");
    positions.put(3, "Billion");
    
        
        if (num == 0) return "Zero";
       String string = Integer.toString(num);
        StringBuilder stb = new StringBuilder(string); 
        int len = string.length(); 
        int rem = len % 3; 
        ArrayList<String> ref = new ArrayList<>(); 
      if (rem != 0) fun(ref, Integer.parseInt(string.substring(0, rem)));
        for (int i = rem; i < len; i+= 3){
            System.out.println(string.substring(i, i + 3));
            fun(ref, Integer.parseInt(string.substring(i, i + 3)));
        }
        System.out.println(ref);
        int tubby = ref.size(); 
        StringBuilder ans = new StringBuilder(); 
        for (int i = 0 ; i < tubby; i++){
            int k = tubby - i - 1; 
            String shake = ref.get(i).strip();
            if (!shake.equals("Zero")){
                ans.append(shake); ans.append(" ");
            }
            if (!shake.equals("Zero") && k != 0){
                ans.append(positions.get(k)); ans.append(" ");
            }
        }
        return ans.toString().strip();
    }
    public void fun(ArrayList<String> ref, Integer x){
        if (x == 0) {ref.add("Zero"); return;}
        String string = Integer.toString(x);
        
        StringBuilder ans = new StringBuilder(); 
        int len = string.length() ;
        for (int i= 0;i < len; i++){
            int k = string.charAt(i) - '0'; 
            if (len - i - 1 == 2){
                ans.append(ones.get(k)); ans.append(" ");
                ans.append("Hundred");
                ans.append(" ");
            }
            else if (len - i - 1 == 1){
                if (k == 1){
                    if (string.charAt(len - 1) == '0'){ans.append("Ten");}
                    if (string.charAt(len - 1) == '1'){ans.append("Eleven");}
                    if (string.charAt(len - 1) == '2'){ans.append("Twelve");}
                    if (string.charAt(len - 1) == '3'){ans.append("Thirteen");}
                    if (string.charAt(len - 1) == '4'){ans.append("Fourteen");}
                    if (string.charAt(len - 1) == '5'){ans.append("Fifteen");}
                    if (string.charAt(len - 1) == '6'){ans.append("Sixteen");}
                    if (string.charAt(len - 1) == '7'){ans.append("Seventeen");}
                    if (string.charAt(len - 1) == '8'){ans.append("Eighteen");}
                    if (string.charAt(len - 1) == '9'){ans.append("Nineteen");}
                    ans.append(" ");
                    break;
                }
                else if (k == 0){
                    continue;
                }
                else{
                    ans.append(tens.get(k));
                   ans.append(" ");
                    }
            }
            else {
                if (k == 0) continue;
                ans.append(ones.get(k));
            }
        }
        ref.add(ans.toString());
    }
}