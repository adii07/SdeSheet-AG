//Number of Dice Rolls With Target Sum


/*
You have n dice and each die has k faces numbered from 1 to k.

Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) to roll the dice so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 109 + 7.

Example 1:

Input: n = 1, k = 6, target = 3
Output: 1
Explanation: You throw one die with 6 faces.
There is only one way to get a sum of 3.
Example 2:

Input: n = 2, k = 6, target = 7
Output: 6
Explanation: You throw two dice, each with 6 faces.
There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
Example 3:

Input: n = 30, k = 30, target = 500
Output: 222616187
Explanation: The answer must be returned modulo 109 + 7.
*/


/**
 * Solution : Recursion with memoisation
 * at each step,i.e., for each dice we can subtract the current face value from the target
 * if the target at any point other than the last dice becomes 0 or less than 0, return zero as it is a negative casr
 * if at the last dice roll if the target becomes zero return 1 else 0
 * 
 * to optimise the solution we add use dp
 * here since the 2 changing parameters are n(dice) and target we use them as the dp matrix index
**/

class Solution {
    final int MOD=1000000000+7;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp=new int[n+1][target+1];
        for(int[] a:dp) Arrays.fill(a,-1);
        return helper(n,k,target,dp);
    }
    
    public int helper(int n,int k,int target,int[][] dp){
        if(n==0){
            return target==0?1:0;
        }
        if(target<0) return 0;
        
        if(dp[n][target]!=-1) return dp[n][target];
        int ans=0;
        
        for(int i=1;i<=k;i++){
            ans=(ans+helper(n-1,k,target-i,dp))%MOD;
        }
        
        return dp[n][target]=ans;
    }
}

/**Solution :Tabulation
 * here we use the same dp matrix as recursion 
 * the base case is when we have to roll the last dice
 * if the value of the target to achieve is less than k, the value at that index can be zero hence we update the value as one
 * if for the last dice the value of target is greater than k we update the value as 0, since the target cannot be achieved
 * then we apply the recursive logic where for each dice, we check if target for 1->target is possible using any of the available face value(1->k)
 * to check for an possible and we check if the current target-current face value are greater than zero and add the value from the prev dice(dp[n-1][t-face]) to the current index.
**/

class Solution {
    final int MOD=1000000000+7;
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp=new int[n+1][target+1];
        for(int i=1;i<=target;i++){
            dp[1][i]=i<=k?1:0;
        }
        
        for(int i=2;i<=n;i++){
            for(int t=1;t<=target;t++){
                for(int face=1;face<=k;face++){
                    if(t-face>=0)
                        dp[i][t]=(dp[i][t]+dp[i-1][t-face])%MOD;
                }
            }
        }
        return dp[n][target];
    }
}

/**Solution : Space optimized tabulation
 * since at each index we only refer to the previous row/index,
 * instead if using a matrix we can only use a prev and a curr array of size(target+1) to store the paramters required 
 * once the current dice is processed we update the prev with it's value and reset the value of the curr array
**/
class Solution {
    final int MOD=1000000000+7;
    public int numRollsToTarget(int n, int k, int target) {
        int[] dp=new int[target+1];
        for(int i=1;i<=target;i++){
            dp[i]=i<=k?1:0;
        }
        
        for(int i=2;i<=n;i++){
            int[] curr=new int[target+1];
            for(int t=1;t<=target;t++){
                for(int face=1;face<=k;face++){
                    if(t-face>=0)
                        curr[t]=(curr[t]+dp[t-face])%MOD;
                }
            }
            dp=curr;
        }
        return dp[target];
    }
}