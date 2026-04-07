//since we inititalixze the stack we can like directly putting valies 0's at initializtion if 
//eelmet has no next greater then it will alrdy be initialized to 0
class Solution 
{
    public int[] dailyTemperatures(int[] temperatures) 
    {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for(int i =n-1;i>=0;i--)
        {
            while(!stack.isEmpty() && temperatures[stack.peek()]<=temperatures[i])
            {
                stack.pop();
            }
            if(!stack.isEmpty())
            {
                result[i]=stack.peek()-i;
            }
            stack.push(i);
        }
        return result;
    }
}
