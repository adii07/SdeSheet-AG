// Decode String
/*
Example 1:
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

Example 2:
Input: s = "3[a2[c]]"
Output: "accaccacc"

Example 3:
Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
*/

class Solution {
    public String decodeString(String s) {
        Stack<String> st=new Stack<>();
        int i=0;
        StringBuilder ans=new StringBuilder();
        while(i<s.length()){
            char ch=s.charAt(i);
            if(ch==']'){
                // get the string
                StringBuilder tmp=new StringBuilder();
                while(!st.isEmpty() && st.peek().charAt(0)!='['){
                    tmp.insert(0,st.pop());
                }
                st.pop();
                // get the number of times it repeats
                int val=0;int j=0;
                while(!st.isEmpty() && Character.isDigit(st.peek().charAt(0))){
                    int a=Integer.parseInt(st.pop());
                    val=val+((int)Math.pow(10,j++)*a);
                }
                //form the repeating string
                String str=tmp.toString();
                while(val-->1) tmp.append(str);
                
                //push the formed string to the stack
                st.push(tmp.toString());
            }else{
                // push every other character
                st.push(ch+"");
            }i++;
        }
        
        // form the final string
        while(!st.isEmpty()){
            ans.insert(0,st.pop());
        }
        
        return ans.toString();
    }
}  