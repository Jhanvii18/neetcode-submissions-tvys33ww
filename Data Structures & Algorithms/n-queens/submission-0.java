class Solution 
{
    List<List<String>> res = new ArrayList<>();
    boolean isSafe(char[][] board, int row, int col, int n)
    {
    // check column (only upward)
    for(int i = 0; i < row; i++)
    {
        if(board[i][col] == 'Q')
            return false;
    }
    // check left diagonal
    int r = row - 1, c = col - 1;
    while(r >= 0 && c >= 0)
    {
        if(board[r][c] == 'Q')
            return false;
        r--;
        c--;
    }
    // check right diagonal
    r = row - 1;
    c = col + 1;
    while(r >= 0 && c < n)
    {
        if(board[r][c] == 'Q')
            return false;
        r--;
        c++;
    }
    return true;
    }
    void backtrack(int n, char[][] board, int row)
    {
        // ✅ BASE CASE
        if(row == n)
        {
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++)
            {
                temp.add(new String(board[i]));
            }
            res.add(temp);
            return;
        }
        // ✅ TRY ALL COLUMNS
        for(int col = 0; col < n; col++)
        {
            if(isSafe(board, row, col, n))
            {
                // place queen
                board[row][col] = 'Q';
                // move to next row
                backtrack(n, board, row + 1);
                // backtrack (undo)
                board[row][col] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) 
    {
        char[][] board = new char[n][n];
        for(int i =0;i<n;i++)
        {
            for(int j =0;j<n;j++)
            {
                board[i][j]='.';
            }
        }
        backtrack(n,board,0);
        return res;
    }
}
