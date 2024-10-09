import java.util.*;
public class MaximalRectangle{
    public static int[][] prefixSum(char[][] matrix){
        int[][] ps = new int[matrix.length][matrix[0].length];
        for(int col = 0; col < matrix[0].length; col++){
            int row = 0;
            while(row < matrix.length){
                if(matrix[row][col]!='0'){
                    if(row > 0){
                        ps[row][col] = 1 + ps[row-1][col];
                    }else{
                        ps[row][col] = 1;
                    }
                }else{
                    ps[row][col] = 0;
                }
                row++;
            }
        }
        return ps;
    }
    public static void main(String[] args){
        char[][] matrix = {
                            {'1', '0', '1', '0', '1'},
                            {'1', '0', '1', '1', '1'},
                            {'1', '1', '1', '1', '1'},
                            {'1', '0', '0', '1', '0'}
                        };
        int[][] ps = prefixSum(matrix);
        for(int i = 0; i < ps.length; i++){
            System.out.println(Arrays.toString(ps[i]));
        }
    }
}