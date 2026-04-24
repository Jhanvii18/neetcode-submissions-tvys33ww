class WordDictionary 
{
    class Trie
    {
        Trie[] children = new Trie[26];
        boolean end = false;
    }

    Trie root;

    public WordDictionary() 
    {
        root = new Trie();
    }

    public void addWord(String word)
    {
        Trie node = root;
        for(char c : word.toCharArray())
        {
            int i = c - 'a';
            if(node.children[i] == null)
                node.children[i] = new Trie();

            node = node.children[i];
        }
        node.end = true;
    }

    public boolean search(String word) 
    {
        List<Trie> nodes = new ArrayList<>();
        nodes.add(root);

        for(char c : word.toCharArray())
        {
            List<Trie> next = new ArrayList<>();

            for(Trie node : nodes)
            {
                if(c == '.')
                {
                    for(int i = 0; i < 26; i++)
                    {
                        if(node.children[i] != null)
                            next.add(node.children[i]);
                    }
                }
                else
                {
                    int i = c - 'a';
                    if(node.children[i] != null)
                        next.add(node.children[i]);
                }
            }

            nodes = next;

            if(nodes.isEmpty())
                return false;
        }

        for(Trie node : nodes)
        {
            if(node.end)
                return true;
        }

        return false;
    }
}