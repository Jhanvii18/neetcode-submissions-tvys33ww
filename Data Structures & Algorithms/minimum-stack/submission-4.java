class MinStack 
{
    Stack<Integer> stack;
    Stack<Integer> minstack;
    public MinStack() 
    {
        stack= new Stack<>();
        minstack = new Stack<>();
    }
    public void push(int val) 
    {
        if(minstack.isEmpty()||val<=minstack.peek())
        {
            minstack.push(val);
        }
        stack.push(val);
    }
    public void pop() 
    {
        if(minstack.peek().equals(stack.peek()))
        {
            minstack.pop();
        }
        stack.pop();
    }
    public int top() 
    {
        return stack.peek();
    }
    public int getMin() 
    {
        return minstack.peek();
    }
}
