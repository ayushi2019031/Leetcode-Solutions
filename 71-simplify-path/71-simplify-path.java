class Solution {
    public String simplifyPath(String path) {
        String[] tokens = path.split("/", path.length());
        Stack<String> q = new Stack<>(); 
        if (path.equals("/"))return path;
        for (int i = 0; i < tokens.length; i++){
            if (!tokens[i].equals("") && !tokens[i].equals(".")){
                if (tokens[i].equals("..")){ if (!q.isEmpty())q.pop();}
                else {q.push(tokens[i]);}
                
            }
        }
        tokens = new String[q.size()];
        int count = q.size() - 1; while (!q.isEmpty()){tokens[count] = q.pop(); count -= 1;}
        System.out.println(Arrays.toString(tokens));
        StringBuilder strb = new StringBuilder("");
        strb.append("/");
        
        for (int i = tokens.length - 1; i >= 0; i--){
            if (tokens[i].equals("") || tokens[i].equals(".")){
                
            }
            else {
                strb.append(tokens[i]);
                strb.append("/");
            }
        }
        String[] fintoks = strb.toString().split("/", path.length());
        StringBuilder ans = new StringBuilder();
       System.out.println(Arrays.toString(fintoks));
        for (int i = fintoks.length - 1; i >= 0; i--){
            if (fintoks[i].length() > 0 && !fintoks[i].equals("/")){
                 ans.append("/");
                ans.append(fintoks[i]);
            }
        }
        if (ans.toString().length() == 0) ans.append("/");
        return ans.toString();
    }
}