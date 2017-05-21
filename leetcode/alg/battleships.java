

Going over all cells, we can count only those that are the "first" cell of the battleship. First cell will be defined as the most top-left cell. We can check for first cells by only counting cells that do not have an 'X' to the left and do not have an 'X' above them.


    public int countBattleships(char[][] board) {
        int m = board.length;
        if (m==0) return 0;
        int n = board[0].length;
        
        int count=0;
        
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i-1][j] == 'X') continue;
                if (j > 0 && board[i][j-1] == 'X') continue;
                count++;
            }
        }
        
        return count;
    }
//same
public class Solution {
    public int countBattleships(char[][] board) {
        int c = 0;
       for(int i=0;i<board.length;i++){
           for(int j=0;j<board[0].length;j++){
               if(board[i][j]=='X'){
                   if(j>0&&i>0){
                       if(board[i][j-1]=='.'&&board[i-1][j]=='.')
                            c++;
                        continue;
                   }
                   if(j>0){
                        if(board[i][j-1]=='.')
                            c++;  
                        continue;
                   }
                   if(i>0){
                       if(board[i-1][j]=='.')
                            c++;
                        continue;
                   }
                   if(board[i][j]=='X')
                        c++;
               }
           }
       }
       return c;
    }
}
