class Solution 
{
    public int evalRPN(String[] tokens) 
    {
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<tokens.length;i++)
        {
            String c = tokens[i];
            if(!c.equals("+") && !c.equals("*") && !c.equals("-") && !c.equals("/"))
            {
                stack.push(Integer.valueOf(tokens[i]));
            }
            else
            {
                int s1 = stack.pop();
                int s2 = stack.pop();

                if(c.equals("+"))
                stack.push(s1+s2);
                else if(c.equals("-"))
                stack.push(s2-s1);
                else if(c.equals("*"))
                stack.push(s1*s2);
                else if(c.equals("/"))
                stack.push(s2/s1);
            }
        }
        return stack.peek();
    }
}
