/* Bag of Tokens
You have an initial power of power, an initial score of 0, and a bag of tokens where tokens[i] is the value of the ith token (0-indexed).
Your goal is to maximize your total score by potentially playing each token in one of two ways:
If your current power is at least tokens[i], you may play the ith token face up, losing tokens[i] power and gaining 1 score.
If your current score is at least 1, you may play the ith token face down, gaining tokens[i] power and losing 1 score.
Each token may be played at most once and in any order. You do not have to play all the tokens.
Return the largest possible score you can achieve after playing any number of tokens.

Example 1:
Input: tokens = [100], power = 50
Output: 0
Explanation: Playing the only token in the bag is impossible because you either have too little power or too little score.

Example 2:
Input: tokens = [100,200], power = 150
Output: 1
Explanation: Play the 0th token (100) face up, your power becomes 50 and score becomes 1.
There is no need to play the 1st token since you cannot play it face up to add to your score.

Example 3:
Input: tokens = [100,200,300,400], power = 200
Output: 2
Explanation: Play the tokens in this order to get a score of 2:
1. Play the 0th token (100) face up, your power becomes 100 and score becomes 1.
2. Play the 3rd token (400) face down, your power becomes 500 and score becomes 0.
3. Play the 1st token (200) face up, your power becomes 300 and score becomes 1.
4. Play the 2nd token (300) face up, your power becomes 0 and score becomes 2.
*/

/**Solution : Sorting and 2 Pointer
 * 
 * given that the order of the token doesnot matter, therefore we can sort the array for a more optimized approach
 * now since the array is sorted we have 2 possible optimized approaches, 2 pointer and binary search
 * here we can add 1 to the score if the value of the token is less than power and subtract the token value from power
 * Simillarly, we can add to the power if the token value is greater than power and reduce the score by 1, but only if the value if score is greater than 1
 * now if there are 2 possible operations of addition or subtraction and the array is sorted, we subtract the value at the front we have enough power and add the last value to the power if we need more power
 * the addition of the last value has an edge case that we need atleast one score else no further operation is possible and we return the ans
 * 
 * */

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int start=0;
        int end=tokens.length-1;
        int score=0;int ans=0;
        while(start<=end){
            if(tokens[start]<=power){
                power-=tokens[start];
                start++;
                score++;
                ans=Math.max(ans,score);
            }else if(score>0 && tokens[end]>power){
                score--;
                power+=tokens[end];
                end--;
            }else return ans;
        }
        return ans;
    }
}