// Longest Repeating Character Replacement
// You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
// Input: s = "AABABBA", k = 1 Output: 4

/**
 * 2 Pointer solution along with a map.
 * Given we can change atmost k characters.
 * Most ideally in an window of simillar characters we tend to change the character that appears the least.
 * Example in the window AABBAA, A appears the most, hence it's ideal to change A and not B.
 * We can use a hashmap or a array of size 26 to keep track of the frequency of the elements in the window.
 * The number of elements to be changed in the window = (Length of window - the frequency of the most frequent character). ------->(i)
 * This number should be less than K in order to fulfil the condition, as we cannot change more than k characters.
 * Therefore we check this condition at each right step to caculate the max length.
 * If this conditon fails, we start to remove the characters from the left of the window.
 * We do this till the condition is again valid.
 * In the process, we also decrement the value of frequency of the element that we remove form the window.
*/
class Solution {
    public final int MIN=Integer.MIN_VALUE;
    public int characterReplacement(String s, int k) {
        int left=0;int length=s.length();
        int ans=MIN;
        int maxFreq=MIN;
        int[] map=new int[26];
        for(int right=0;right<length;right++){
            char ch=s.charAt(right);
            int freq=++map[ch-'A'];
            maxFreq=Math.max(maxFreq,freq);
            int toChange=(right-left+1-maxFreq); //------->(i)
            if(toChange>k){
                map[s.charAt(left++)-'A']--;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}