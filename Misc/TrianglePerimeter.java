/**Largest Perimeter Triangle
Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.

Input: nums = [2,1,2]
Output: 5

Input: nums = [1,2,1]
Output: 0
*/


/*
To solve this problem, all you need to know are the basic facts about a triangle, and the question says the largest perimeter triangle. Execute the second fact below on the basis of the largest value in the array.

Basic facts:

-The sum of all the internal angles of a triangle is always 180o no matter how the triangle is constructed.
-The length of any side of a triangle is shorter than the sum of the other two sides.
-A triangle can always be split into two right triangles no matter how the triangle is constructed.
*/
class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i=nums.length-3;i>=0;i--){
            if(nums[i+2]<nums[i]+nums[i+1]) return nums[i]+nums[i+1]+nums[i+2];
        }
        return 0;
    }
}