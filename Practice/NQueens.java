import java.util.*;

public class NQueens {

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(board, 0, result);
        return result;
    }

    public static void backtrack(char[][] board, int row, List<List<String>> result) {
        int n = board.length;
        if (row == n) {
            result.add(constructBoard(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, result);  
                board[row][col] = '.';
            }
        }
    }

    public static boolean isSafe(char[][] board, int row, int col) {  
        int n = board.length;
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static List<String> constructBoard(char[][] board) {  
        List<String> solution = new ArrayList<>();
        for (char[] row : board) {
            solution.add(new String(row));
        }
        return solution;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> queen = solveNQueens(n);  
        int i = 1;
        for (List<String> it : queen) { 
            System.out.println("Solution " + i);
            for (String c : it) {
                System.out.println(c);
            }
            i++;
        }
    }
}