//approach - DFS + Backtracking
//time - O(m*n * 4^m*n) - At every element in board we are travelling 4 directions (4^m*n) and we are doing this for every element ie m*n times
//space - O(word.length()) - In the recursive stack space we will have at the most word.length() elements
public class WordSearch {
    boolean result;
    int m, n;
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0) {
            return false;
        }

        m = board.length;
        n = board[0].length;

        //find the first character and then start the dfs and backtracking
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    backtrack(board, word, 0, i, j);
                }
            }
        }

        return result;
    }
    private void backtrack(char[][] board, String word, int index, int row, int col) {
        if(index == word.length()) {
            result = true;
            return;
        }
        if(row < 0 || row == m || col < 0 || col == n) {
            return;
        }

        //only if char at index in word matches the char in the board at current position only then proceed with dfs and backtracking
        if(board[row][col] == word.charAt(index)) {
            //action
            char temp = board[row][col];
            board[row][col] = '#';
            //recurse
            backtrack(board, word, index+1, row+1, col);
            backtrack(board, word, index+1, row-1, col);
            backtrack(board, word, index+1, row, col-1);
            backtrack(board, word, index+1, row, col+1);
            //backtrack
            board[row][col] = temp;
        }
    }
}