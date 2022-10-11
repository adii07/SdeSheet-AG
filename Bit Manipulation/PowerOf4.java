/**
 * We can use the log methid as used in power of 3 
 * Or we can use this method which states that a number is a power of 4 only and only if it is an power of 2 and it's remainder with 3 is 1.
**/
class Solution {
    public boolean isPowerOfFour(int n) {
        return ((n & (n - 1)) == 0) && (n % 3 == 1);
    }
}