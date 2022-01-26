// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Node{
    char c;

    Node next;
    Node prev; 
    public Node(){this.c = '#';}
    public Node(char t){
        this.c = t; 
    }

}
public class Solution {
    public String FirstNonRepeating(String A) {
        StringBuilder strb = new StringBuilder(); 
        Node head = new Node();
        boolean[] k = new boolean[26];
        for (int i = 0; i < A.length(); i++){
            char c = A.charAt(i); 
            if (k[c - 'a'] == false){
                Node curr = head; 
                while (curr.c != c && curr.next != null){
                    curr = curr.next; 
           //         System.out.println(curr.c);
                }
                if (curr.next == null){
                    if (curr.c == c){
                        k[c - 'a'] = true;
                        curr.prev.next = curr.next;
                        if (curr.next != null)curr.next.prev = curr.prev;
                    }
                    else {
                        curr.next = new Node(c);
                        curr.next.prev = curr;
                    }
                }
                else if (curr.c == c){
                    k[c - 'a'] = true;
                        curr.prev.next = curr.next;
                    if (curr.next != null)    curr.next.prev = curr.prev;
                }
            }
            if (head.next == null){strb.append(Character.toString('#'));}
            else strb.append(Character.toString(head.next.c));
        }
    
    return strb.toString(); 
}
}