// Reordered Power of 2
/*
You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.
Return true if and only if we can do this so that the resulting number is a power of two.

Input: n = 1
Output: true

Input: n = 10
Output: false

Input: n = 23
Output: true
*/

/**
 * Solution 1: Permutations
 * Find all the possible permutations of the number and check if it is an power of 2
**/
class Solution {
    public boolean reorderedPowerOf2(int N) {
        // Build eg. N = 128 -> A = [1, 2, 8]
        String S = Integer.toString(N);
        int[] A = new int[S.length()];
        for (int i = 0; i < S.length(); ++i)
            A[i] = S.charAt(i) - '0';
        return permutations(A, 0);
    }

    // Return true if A represents a valid power of 2
    public boolean isPowerOfTwo(int[] A) {
        if (A[0] == 0) return false;  // no leading zero

        // Build eg. A = [1, 2, 8] -> N = 128
        int N = 0;
        for (int x: A)
            N = 10 * N + x;

        // Remove the largest power of 2
        while (N > 0 && ((N & 1) == 0))
            N >>= 1;

        // Check that there are no other factors besides 2
        return N == 1;
    }

    /**
     * Returns true if some permutation of (A[start], A[start+1], ...)
     * can result in A representing a power of 2.
     */
    public boolean permutations(int[] A, int start) {
        if (start == A.length)
            return isPowerOfTwo(A);

        // Choose some index i from [start, A.length - 1]
        // to be placed into position A[start].
        for (int i = start; i < A.length; ++i) {
            // Place A[start] with value A[i].
            swap(A, start, i);

            // For each such placement of A[start], if a permutation
            // of (A[start+1], A[start+2], ...) can result in A
            // representing a power of 2, return true.
            if (permutations(A, start + 1))
                return true;

            // Restore the array to the state it was in before
            // A[start] was placed with value A[i].
            swap(A, start, i);
        }

        return false;
    }

    public void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}


/**
 * Solution 2: Using Count/Frequency map
 * there can only be 10 unique digits in a number(0-9)
 * find the frequency of the digits in the given number
 * there are oonly 31 power of 2 in the range till 10^9
 * therefore for each power of 2(num<<1) we find the frequency map of digits and compare it to the frequency map of the given number
**/
class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] A = count(n);
        int val=1;
        for (int i = 0; i < 31; ++i){
            if (Arrays.equals(A, count(val)))
                return true;
            val=val<<1;
        }
        
        return false;
    }

    public int[] count(int n) {
        int[] ans = new int[10];
        while (n > 0) {
            ans[n % 10]++;
            n /= 10;
        }
        return ans;
    }
}