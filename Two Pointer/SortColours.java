//Sort Colors
//Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//Input: nums = [2,0,2,1,1,0] Output: [0,0,1,1,2,2]


/**
 * Make partitions for 0,1 and 2.
 * The area between the start and i pointer is for zero
 * The area from the last till i is for 2
 * When we swap 2, the i pointer doesnot move, as the value swapped at i pointer could be anything 
*/

class Solution {
    public void sortColors(int[] nums) {
        int zero=0;
        int one=0;
        int two=nums.length-1;
        while(one<=two){
            if(nums[one]==0){
                nums[one++]=nums[zero];
                nums[zero++]=0;
            }else if(nums[one]==2){
                nums[one]=nums[two];
                nums[two--]=2;
            }else{
                one++;
            }
        }
    }
}