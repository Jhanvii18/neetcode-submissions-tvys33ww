class Solution 
{
    public int evalRPN(String[] tokens) 
    {
    Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++)
        {
            String ch = tokens[i];
            if (!ch.equals("+") && !ch.equals("-") &&
                !ch.equals("*") && !ch.equals("/"))
            {
                stack.push(Integer.parseInt(ch));
            }
            else
            {
                int s1 = stack.pop();
                int s2 = stack.pop();

                if (ch.equals("+"))
                    stack.push(s2 + s1);
                else if (ch.equals("*"))
                    stack.push(s2 * s1);
                else if (ch.equals("-"))
                    stack.push(s2 - s1);
                else
                    stack.push(s2 / s1);
            }
        }

        return stack.peek();
    }
}