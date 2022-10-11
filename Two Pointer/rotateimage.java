// rotate image by 90 degree
class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            int up=0;
            int down=n-1;
            while(up<down){
                int temp=matrix[up][i];
                matrix[up][i]=matrix[down][i];
                matrix[down][i]=temp;
                up++;
                down--;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
}