class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<>();
        return fun(input, 0, input.length() - 1);
    }
    public List<Integer> fun(String input, int s, int e){
    List<Integer> list = new ArrayList<Integer>();
    if (s > e){return list;}
    if (s == e){
        int k =  Integer.parseInt(Character.toString(input.charAt(s)));
        list.add(k);
        return list;
    }
//    List<Integer> list = new ArrayList<Integer>();
        boolean fg = false;
    for (int i = s; i <= e; i++){
        char t = input.charAt(i);
        if (t == '*' || t == '+' || t == '-'){
            fg = true;
            List<Integer> l1 = fun(input, s, i - 1);
            List<Integer> l2 = fun(input, i + 1, e);
            for (int k1: l1){
                for (int k2: l2){
                    if (t == '*'){
                        list.add(k1*k2);
                    }
                    else if (t == '+'){
                        list.add(k1 + k2);
                    }
                    else{
                        list.add(k1 - k2);
                    }
                }
            }
        }
    }
        if (fg == false){list.add(Integer.parseInt(input.substring(s, e+ 1)));}
        return list;
    }
}