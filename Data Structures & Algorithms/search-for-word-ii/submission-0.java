class Solution 
{
    class TrieNode 
    {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) 
    {
        // build trie
        for(String w : words)
        {
            TrieNode node = root;
            for(char c : w.toCharArray())
            {
                int i = c - 'a';
                if(node.children[i] == null)
                    node.children[i] = new TrieNode();
                node = node.children[i];
            }
            node.word = w;
        }

        List<String> res = new ArrayList<>();

        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                dfs(board, i, j, root, res);
            }
        }

        return res;
    }

    void dfs(char[][] board, int i, int j, TrieNode node, List<String> res)
    {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return;

        char c = board[i][j];

        if(c == '#' || node.children[c - 'a'] == null)
            return;

        node = node.children[c - 'a'];

        if(node.word != null)
        {
            res.add(node.word);
            node.word = null; // avoid duplicates
        }

        board[i][j] = '#';

        dfs(board, i+1, j, node, res);
        dfs(board, i-1, j, node, res);
        dfs(board, i, j+1, node, res);
        dfs(board, i, j-1, node, res);

        board[i][j] = c;
    }
}