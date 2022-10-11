// Numbers With Same Consecutive Differences

/*
Return all non-negative integers of length n such that the absolute difference between every two consecutive digits is k.
Note that every number in the answer must not have leading zeros. For example, 01 has one leading zero and is invalid.
You may return the answer in any order.

Input: n = 3, k = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.

Input: n = 2, k = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]

*/

/**
 * Solution : Use Bfs(queue)
 * since we cannot have a number with leading zero, we skip zero and add all the other numbers from 1 to 9 in the queue
 * we form a pair to store the number formed till now along with the number of digits left
 * once while traversing the queue we encounter a  pair with number of digits left(pair.digits) as zero we add it to the queue
 * else we consider the last digit of the number at top(num%10=x) and check if x-k and x+k lie in the valid constraint(0<=x<=9)
 * if yes we add the number to the queue((num*10)+x) while decresing the digit left count by 1
**/
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        Set<Integer> list=new HashSet<>();
        Queue<Pair> q=new LinkedList<>();
        
        for(int i=1;i<=9;i++){
            q.add(new Pair(i,n-1));
        }
        while(!q.isEmpty()){
            Pair head=q.remove();
            int lastDigit=head.val%10;
            if(head.digit==0){
                list.add(head.val);
                continue;
            }
            if(lastDigit+k<=9){
                q.add(new Pair((head.val*10+(lastDigit+k)),head.digit-1));
            }
            if(lastDigit-k>=0){
                q.add(new Pair((head.val*10+(lastDigit-k)),head.digit-1));
            }
        }
        
        int[] ans=new int[list.size()];
        int i=0;
        for(int val:list) ans[i++]=val;
        
        return ans;
    }
}

class Pair{
    int val;
    int digit;
    Pair(){}
    Pair(int val,int digit){
        this.val=val;
        this.digit=digit;
    }
}