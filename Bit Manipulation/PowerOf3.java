/**
 * num=3^i
 * log(num)=i*log(3)
 * i=log(min)/log(3)
 * If this i is an integer,i.e, doesn't have any decimal the value is a power of 3*/
class Solution {
    public boolean isPowerOfThree(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}