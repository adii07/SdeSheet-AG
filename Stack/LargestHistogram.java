//Largest Rectangle in Histogram
/**
 * Approach 1
 * using 2 arrays
 * multiple traversals
 * */
class Solution {
    public int largestRectangleArea(int[] height) {
        int n=height.length;
        Stack<Integer> st=new Stack<>();
        int[] lMin=new int[n];
        int[] rMin=new int[n];
        
        for(int i=0;i<n;i++){
            int val=height[i];
            while(!st.isEmpty() && height[st.peek()]>=val){
                st.pop();
            }
            lMin[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            int val=height[i];
            while(!st.isEmpty() && height[st.peek()]>=val){
                st.pop();
            }
            rMin[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        
        int ans=0;
        
        for(int i=0;i<n;i++){
//            System.out.println(rMin[i]+" , "+lMin[i]);
            int val=rMin[i]-lMin[i]-1;
            ans=Math.max(ans,val*height[i]);
        }
        return ans;
    }
}
/**
 * Approach 2
 * using no array
 * single traversal
 * */
class Solution {
    public int largestRectangleArea(int[] height) {
        int n=height.length;
        int ans=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || height[st.peek()]>height[i] )){
                int prev=st.pop();
                int index=st.isEmpty()?i:(i-st.peek()-1);
                int tmp=index*height[prev];
                ans=Math.max(ans,tmp);
            }
            st.push(i);
        }
        return ans;
    }
}