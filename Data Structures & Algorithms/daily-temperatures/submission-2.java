//when we create a result arry the lements inside it will be initialized to 0
//so thats how the value 0 is initialized for the last index in reulst array 
class Solution 
{
    public int[] dailyTemperatures(int[] temperatures) 
    {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        for(int i=n-1;i>=0;i--)
        {
            while(!stack.isEmpty()&&temperatures[stack.peek()]<=temperatures[i])
            {
                stack.pop();
            }

            if(!stack.isEmpty())
            result[i]=stack.peek()-i;

            stack.push(i);
        }
        return result;
    }
}
