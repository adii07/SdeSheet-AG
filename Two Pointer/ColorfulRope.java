/* Minimum Time to Make Rope Colorful

* Alice has n balloons arranged on a rope. You are given a 0-indexed string colors where colors[i] is the color of the ith balloon.
* Alice wants the rope to be colorful. She does not want two consecutive balloons to be of the same color, so she asks Bob for help. Bob can remove some balloons from the rope to make it colorful. You are given a 0-indexed integer array neededTime where neededTime[i] is the time (in seconds) that Bob needs to remove the ith balloon from the rope.
* Return the minimum time Bob needs to make the rope colorful.

Input: colors = "abaac", neededTime = [1,2,3,4,5]
Output: 3
Explanation: In the above image, 'a' is blue, 'b' is red, and 'c' is green.
Bob can remove the blue balloon at index 2. This takes 3 seconds.
There are no longer two consecutive balloons of the same color. Total time = 3.

Input: colors = "abc", neededTime = [1,2,3]
Output: 0
Explanation: The rope is already colorful. Bob does not need to remove any balloons from the rope.


Input: colors = "aabaa", neededTime = [1,2,3,4,1]
Output: 2
Explanation: Bob will remove the ballons at indices 0 and 4. Each ballon takes 1 second to remove.
There are no longer two consecutive balloons of the same color. Total time = 1 + 1 = 2.
*/

/** Solution 1: 2 pointer
 * */

 class Solution {
    public int minCost(String colors, int[] neededTime) {
        // Initalize two pointers i, j.
        int totalTime = 0;
        int i = 0, j = 0;
        
        while (i < neededTime.length && j < neededTime.length) {
            int currTotal = 0, currMax = 0;
            
            // Find all the balloons having the same color as the 
            // balloon indexed at i, record the total removal time 
            // and the maximum removal time.
            while (j < neededTime.length && colors.charAt(i) == colors.charAt(j)) {
                currTotal += neededTime[j];
                currMax = Math.max(currMax, neededTime[j]);
                j++;
            }
            
            // Once we reach the end of the current group, add the cost of 
            // this group to total_time, and reset two pointers.
            totalTime += currTotal - currMax;
            i = j;
        }
        return totalTime;    
    }
}

/** Sloution 2: One pass*/

class Solution {
    public int minCost(String colors, int[] neededTime) {
        // totalTime: total time needed to make rope colorful;
        // currMaxTime: maximum time of a balloon needed.
        int totalTime = 0, currMaxTime = 0;
        
        // For each balloon in the array:
        for (int i = 0; i < colors.length(); ++i) {
            // If this balloon is the first balloon of a new group
            // set the currMaxTime as 0.
            if (i > 0 && colors.charAt(i) != colors.charAt(i - 1)) {
                currMaxTime = 0;
            }
            
            // Increment totalTime by the smaller one.
            // Update currMaxTime as the larger one.
            totalTime += Math.min(currMaxTime, neededTime[i]);
            currMaxTime = Math.max(currMaxTime, neededTime[i]);
        }
        
        // Return totalTime as the minimum removal time.
        return totalTime;
    }
}