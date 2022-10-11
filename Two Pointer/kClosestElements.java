/*
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. 
The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:
    |a - x| < |b - x|, or
    |a - x| == |b - x| and a < b
*/

/**Solution 1:Binary Search and 2 pointer
 * Find the index at which the element is to be inserted
 * binary search can be used as the array is sorted(let n=index of x)
 * once the index is found add it to the ans, as it will surely be the closest to the given x and reduce k by 1
 * now assign a left and a right pointer to find the next values
 * the value of left is n-1 and right is n+1
 * run a loop till k!=0 or left<0  or right>=len
 * now use the given logic to find the next value
 * if the abs value of left-x id smaller than right-x or if they are equal and left is smaller add left
 * else add right
 * check if k!=0 and either of left or right is left, if yes add to the ans
 * since the ans is to be in sorted order,we need to add the left value at index 0 and the right value at the last index
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans=new ArrayList<>();
        int n=binarySearch(arr,x);
        ans.add(arr[n]);
        k--;
        int left=n-1;
        int right=n+1;
        while(left>=0 && right<arr.length && k>0){
            int n1=arr[left];
            int n2=arr[right];
            if(Math.abs(n1-x)<Math.abs(n2-x)){
                ans.add(0,n1);
                left--;
            }else if(Math.abs(n1-x)==Math.abs(n2-x) && n1<n2){
                ans.add(0,n1);
                left--;
            }else{
                ans.add(n2);
                right++;
            }
            k--;
        }
        while(k>0 && left>=0){
            ans.add(0,arr[left--]);
            k--;
        }
        while(k>0 && right<arr.length){
            ans.add(arr[right++]);
            k--;
        }
        return ans;
    }
    public int binarySearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        int min = Integer.MAX_VALUE;
        int idx = Integer.MAX_VALUE;
        
        while(low <= high) {
            int mid = (low+high)/2;
            
            if(Math.abs(arr[mid] - x) <= min) {
                if(min == Math.abs(arr[mid] - x)) {
                    idx = Math.min(mid, idx);
                } else {
                    idx = mid;
                    min = Math.abs(arr[mid] - x);
                }
            }
            
            if(arr[mid] < x) {
                low = mid+1;
            } else if(arr[mid] > x) {
                high = mid -1;
            } else {
                return mid;
            }
        }
        
        return idx;
    }
}