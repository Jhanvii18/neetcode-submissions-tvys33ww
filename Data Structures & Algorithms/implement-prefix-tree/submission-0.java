// teh first layer is going to be 26(fixed)
/*TrieNode
------------------------------------------
| children[0] → 'a' → new trie / null     |
| children[1] → 'b' → new trie / null     |
| children[2] → 'c' → new trie / null     |
| children[3] → 'd' → new trie / null     |
| ...                                    |
| children[25] → 'z' → pointer / null    |
------------------------------------------
| isEnd = true / false                   |
------------------------------------------*/
class Trie
{
    Trie[] children = new Trie[26];
    boolean end = false;
}
class PrefixTree 
{
    Trie root;
    public PrefixTree() 
    {
        root = new Trie();
    }
    public void insert(String word) 
    {
        Trie node = root;  
        for(char c:word.toCharArray())
        {
            int i = c-'a';
            if(node.children[i]==null)
            {
                node.children[i]=new Trie();
            }
            node = node.children[i];
        }
        node.end=true;
    }
    public boolean search(String word) 
    {
        Trie node = root;
        for(char c : word.toCharArray())
        {
            int i = c-'a';

            if(node.children[i]==null)
            return false;

            node = node.children[i];
        }
        return node.end;
    }
    public boolean startsWith(String prefix) 
    {
        Trie node = root;
        for(char c:prefix.toCharArray())
        {
            int i = c-'a';

            if(node.children[i]==null)
            return false;

            node = node.children[i];
        }
        return true;
    }
}
