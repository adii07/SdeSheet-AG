//  Roman to Integer
/*
    Example 1:
    Input: s = "III"
    Output: 3
    Explanation: III = 3.

    Example 2:
    Input: s = "LVIII"
    Output: 58
    Explanation: L = 50, V= 5, III = 3.

    Example 3:
    Input: s = "MCMXCIV"
    Output: 1994
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
*/

class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);map.put('V',5);map.put('X',10);
        map.put('L',50);map.put('C',100);map.put('D',500);
        map.put('M',1000);
        
        int sum = 0;
        int prev = map.get(s.charAt(0));
        int next = 0;

        for (int i = 1; i < s.length(); i++) {
            next = map.get(s.charAt(i));

            if (prev < next) {
                sum -= prev;
            } else {
                sum += prev;
            }

            prev = next;
        }

        sum += prev;
        return sum;        
    }
}