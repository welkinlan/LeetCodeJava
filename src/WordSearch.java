import java.util.ArrayList;

/**
 * Created by tianlan on 6/11/2014.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (word.equals("")) return false;
        int row = board.length;
        if (row == 0) return false;
        int col = board[0].length;
        if (col == 0) return false;
        boolean visited[][] = new boolean[row][col];
        for(int r=0; r<board.length; r++)
        {
            for(int c=0; c<board[0].length; c++)
            {
                if(search(board, word, 0, r, c, visited))
                    return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int index, int r, int c, boolean[][] visited){
        if (index == word.length())
            return true;
        if (r<0 || c<0 || r>=board.length || c>=board[0].length || visited[r][c] || board[r][c]!=word.charAt(index))
            return false;
        visited[r][c] = true;
        boolean result = search(board, word, index+1, r-1,c, visited) || search(board, word, index+1, r+1,c, visited)||
                         search(board, word, index+1, r,c+1, visited) || search(board, word, index+1, r, c-1, visited);
        visited[r][c] = false;
        return result;
    }

}
