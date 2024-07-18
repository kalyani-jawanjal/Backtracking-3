import java.util.ArrayList;
import java.util.List;

//Time - O(n!) - n factorial, Space - O(n^2)
public class NQueens {
    List<List<String>> result;
    boolean[][] grid;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n == 0) return result;
        grid = new boolean[n][n];
        backtrack(0);
        return result;
    }
    private void backtrack(int row) {
        //base
        if(row == grid.length) {
            List<String> path = new ArrayList<>();
            for(int i=0; i<grid.length; i++) {
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<grid[0].length; j++) {
                    if(grid[i][j]) {
                        sb.append('Q');
                    } else {
                        sb.append('.');
                    }
                }
                path.add(sb.toString());
            }
            result.add(path);
        }

        //logic
        for(int i=0; i<grid[0].length; i++) {
            if(isSafe(row, i)) {
                //action
                grid[row][i] = true;
                //recurse
                backtrack(row+1);
                //backtrack
                grid[row][i] = false;
            }
        }
    }
    private boolean isSafe(int row, int col) {
        //check upwards
        int i = row-1;
        int j = col;
        while(i >= 0 && j >= 0) {
            if(grid[i][j]) {
                return false;
            }
            i--;
        }

        //check left diagonal
        i = row - 1;
        j = col - 1;
        while(i >= 0 && j >= 0) {
            if(grid[i][j]) {
                return false;
            }
            i--;
            j--;
        }

        //check right diagonal
        i = row - 1;
        j = col + 1;
        while(i >= 0 && j < grid[0].length) {
            if(grid[i][j]) {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }
}