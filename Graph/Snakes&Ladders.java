class Solution {
    int n;
    public int snakesAndLadders(int[][] board) {
        this.n=board.length;
        Queue<Integer> q=new LinkedList<>();
        HashSet<Integer> visited=new HashSet<>();
        q.add(1);visited.add(1);
        int move=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int head=q.remove();
                if(head==n*n) return move;
                for(int i=head+1;i<=Math.min(head+6,n*n);i++){
                    Pair tmp=getPos(i-1);
                    int val=board[tmp.row][tmp.col];
                    if(val!=-1){
                        if(!visited.contains(val)){
                            visited.add(val);
                            q.add(val);
                        }
                    }else{
                        if(!visited.contains(i)){
                            visited.add(i);
                            q.add(i);
                        }
                    }
                }
            }
            move++;
        }
        return -1;
    }
    
    public Pair getPos(int val){
        int row=(n-1)-(val/n);
        int col=(val/n)%2==0?val%n:(n-1)-(val%n);
        return new Pair(row,col);
    }
}
class Pair{
    int row;
    int col;
    Pair(){}
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
/**
 * Position of an value num 
 * row=(n-1)-((num-1)/n)-> this is because number 1 starts from the bottom
 * */