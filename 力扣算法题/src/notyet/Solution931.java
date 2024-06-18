package notyet;

public class Solution931 {
    /*
    *   2   1   3
    *   7   6   5
    *   13  13  14
    * 和上题思路一样
    * */
    public int minFallingPathSum(int[][] matrix) {
        int length = matrix.length;
        if (length==1)return matrix[0][0];
        for (int i = 1; i < length; i++) for (int j = 0; j < matrix.length; j++)min(matrix,i-1,j-1);
        int min = matrix[length-1][0];
        for (int i = 1; i < length; i++) min = Math.min(matrix[length-1][i],min);
        return min;
    }
    public int min(int[][] matrix,int i,int start){
        if (start<0)matrix[i+1][start+1]+=Math.min(matrix[i][start+1],matrix[i][start+2]);
        else if (start+2==matrix.length)matrix[i+1][start+1]+=Math.min(matrix[i][start],matrix[i][start+1]);
        else matrix[i+1][start+1]+=Math.min(matrix[i][start],Math.min(matrix[i][start+1],matrix[i][start+2]));
        return matrix[i+1][start+1];
    }
}
