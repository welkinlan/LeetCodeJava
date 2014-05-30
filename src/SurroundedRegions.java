/**
 * Created by tianlan on 5/29/2014.
 */
public class SurroundedRegions {
    static boolean visited[][];
    static boolean good[][];

    public static void solve(char[][] board) {
        visited = new boolean[board.length][board.length];
        good = new boolean[board.length][board.length];
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board.length; j++){
                if (!visited[i][j]){
                    if (board[i][j] == 'X'){
                        visited[i][j] = true;
                        good[i][j] = true;
                    }
                    else{
                        good[i][j] = explore(i,j, board);
                        if(good[i][j]){
                            board[i][j] = 'X';
                        }
                        visited[i][j] = true;
                    }
                }
            }
        }
    }


    public static boolean explore(int i, int j, char[][] board){
        System.out.println(i+","+j);
        if (visited[i][j]) return good[i][j];
        //if border
        if (i==0 || i==board.length || j==0 || j==board.length){
            if (board[i][j] == 'X') {
                visited[i][j] = true;
                good[i][j] = true;
                return true;
            }
            else {
                visited[i][j] = true;
                good[i][j] = false;
                return false;
            }
        }
        if (board[i][j] == 'X') return true;
        if (visited[i-1][j] && visited[i+1][j] && visited[i][j-1] && visited[i][j+1]){
            return good[i-1][j] && good[i+1][j] && good[i][j-1] && good[i][j+1];
        }

        return (explore(i-1,j,board) && explore(i+1,j,board) &&
                explore(i,j-1,board) && explore(i,j+1,board));
    }

    public static void main(String[] args){
        char array[][] = {{'X','X','X','X'},
                          {'X','O','O','X'},
                          {'X','X','O','X'},
                          {'X','O','X','X'}};
        solve(array);
        for (int i=0; i<array.length; i++){
            for (int j=0; j<array.length; j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
