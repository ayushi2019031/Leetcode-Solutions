class Solution {
    public String removeKdigits(String num, int k) {
        //If the number's length == k then return 0. Entire number is removed.
        if(num.length()==k)
            return "0";
        
        //
        
         Stack<Character> stack = new Stack<>();
        int i =0;
        while(i<num.length()){
            //whenever meet a digit which is less than the previous digit, discard the previous one
            //K keeps a count of the number of digits already removed.
            //Its necesary to check that the comparision takes place only when the stack is not empty. if its empty directly add the element.
            //next is if the peek elemet is less than the current remove it. 
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
               System.out.println(stack.pop());
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }
        
        // corner case like "1111"
        
        while(k>0){
            System.out.println(k);
            stack.pop();
            k--;            
        }
       
        //Removing if any leading zeros.
        Boolean nonzero = false;
        String result = "";
        while(!stack.isEmpty())
        {
            char present = stack.pop();
            result = present+result;
        }
        
        String res = "";
        int start = 0;
        while(start<result.length())
        {
            if(result.charAt(start)=='0' && nonzero==false)
                res = res;
            else
            {
                res = res+result.charAt(start);
                nonzero = true;
            }
            
            start++;
        }

        if(res.length()==0)
            return "0";
        
        return res;
    }
    }
