import java.util.ArrayList;

/**
 * Created by tianlan on 5/29/2014.
 */
public class SurroundedRegions {
    static ArrayList<Integer> xIndex;
    static ArrayList<Integer> yIndex;
    public static void solve(char[][] board) {
        int row = board.length;
        if (row == 0) return;
        int col = board[0].length;
        xIndex = new ArrayList<Integer>();
        yIndex = new ArrayList<Integer>();

        //scan 4 sides of the matrix, store all 'O's
        for (int i=0; i<row; i++){
            //left border
            if (board[i][0] == 'O'){
                xIndex.add(i);
                yIndex.add(0);
            }
            //right border
            if (board[i][col-1] == 'O'){
                xIndex.add(i);
                yIndex.add(col-1);
            }
        }
        for (int i=0; i<col; i++){
            //left border
            if (board[0][i] == 'O'){
                xIndex.add(0);
                yIndex.add(i);
            }
            //right border
            if (board[row-1][i] == 'O'){
                xIndex.add(row-1);
                yIndex.add(i);
            }
        }
        //BFS: replace all 'O's connected to the 'O's on the sides as 'Y'
        int k=0;
        while(k<xIndex.size()){
            int x = xIndex.get(k);
            int y = yIndex.get(k);
            board[x][y] = 'Y';
            if(x>0 && board[x-1][y] == 'O' ) {xIndex.add(xIndex.size()-1,x-1); yIndex.add(yIndex.size()-1,y);} //up
            if(x<row-1 && board[x+1][y] == 'O' ) {xIndex.add(xIndex.size()-1,x+1); yIndex.add(yIndex.size()-1,y);} //down
            if(y>0 && board[x][y-1] == 'O' ) {xIndex.add(xIndex.size()-1,x); yIndex.add(yIndex.size()-1,y-1);} //left
            if(y<col-1 && board[x][y+1] == 'O' ) {xIndex.add(xIndex.size()-1,x); yIndex.add(yIndex.size()-1,y+1);} //right
            k++;
        }
        //recover all 'Y's as 'O', replace surviving 'O's as 'X'
        for(int i =0; i< row; i++)
        {
            for(int j =0; j< col; j++)
            {
                if(board[i][j] =='O') board[i][j] = 'X';
                if(board[i][j] == 'Y') board[i][j] = 'O';
            }
        }

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
