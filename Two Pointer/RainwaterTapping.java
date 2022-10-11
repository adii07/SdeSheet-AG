// Trapping Rain Water

/**
 * Approach 1
 * First we tend to use 2 array Lmax and Rmax to store the largest value towards the right and the largest value towards the left of the ith index(including)
 * the basic intution is that we can only store the amount of water that has been inclosed within the maximum of the edges of the ith index
 * */

/**
 * Approach 2 
 * Here we aim at reducing the space and time complexity
 * we donot need the 2 arrays
 * we just need a single array and the rest can be taken care of while traversing
 * */


 class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] rightMax=new int[n];
        int max=height[n-1];
        for(int i=n-2;i>=0;i--){
            max=Math.max(max,height[i]);
            rightMax[i]=max;
        }
        max=height[0];
        int ans=0;
        for(int i=1;i<n-1;i++){
            max=Math.max(max,height[i]);
            int water=(Math.min(max,rightMax[i])-height[i]);
            ans+=water;
            System.out.println(i+" -> "+water);
        }
        return ans;
    }
}

/**
 * Approach 3
 * here we reduce the space complexity even further
 * The approach is as follows:
 * While traversing we need to be sure that there is an index greater than or equal to the leftmax for a given i
 * this can be made sure by comparing the left and the right pointer and moving only the smaller one, this ensure that there is an value greater than or equal to in the required direction
 * then once we are sure that there is a value greater than the max, we tend to find the water stored
 * to calculate the water stored, we consider the smaller index of left or right
 * then we check if the index is the largest in it's repsctive side, if it is the largest it cannot store any water as it will overflow, hence we use it to update the max
 * if the index is not the largest, then the differnce between the largest in the respective side -  the index is the amount of water stored at the given index
 * */

 class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int ans=0;
        int left=0,right=n-1;
        int lMax=0,rMax=0;
        while(left<right){
            if(height[left]<=height[right]){
                if(height[left]>=lMax) lMax=height[left];
                else ans+=lMax-height[left];
                left++;
            }else{
                if(height[right]>=rMax) rMax=height[right];
                else ans+=rMax-height[right];
                right--;
            }
        }
        return ans;
    }
}