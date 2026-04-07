class Solution 
{
    public boolean isValidSudoku(char[][] board) 
    {
        for(int i=0;i<9;i++)
        {
            Set<Character> set = new HashSet<>();
            for(int j=0;j<9;j++)
            {
                char c = board[i][j];
                if(c!='.')
                {
                    if(set.contains(c))
                    {
                        return false;
                    }
                    set.add(c);
                }
            }
        }
        for(int i=0;i<9;i++)
        {
            Set<Character> set = new HashSet<>();
            for(int j=0;j<9;j++)
            {
                char c = board[j][i];
                if(c!='.')
                {
                    if(set.contains(c))
                    {
                        return false;
                    }
                }
                set.add(c);
            }
        }
        for(int boxrow=0;boxrow<9;boxrow=boxrow+3)
        {
            for(int boxcol=0;boxcol<9;boxcol=boxcol+3)
            {
                Set<Character> set = new HashSet<>();
                for(int i=boxrow;i<boxrow+3;i++)
                {
                    for(int j=boxcol;j<boxcol+3;j++)
                    {
                        char c = board[i][j];
                        if(c!='.')
                        {
                            if(set.contains(c))
                            {
                                return false;
                            }
                            set.add(c);
                        }
                    }
                }
            }
        }
        return true;
    }
}
