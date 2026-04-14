// we will us deque 
// fornt eelment in dque  will store the largest element 
// we have to achieve complexity of o(n) thus we cannot like do sorting we need sorted in o(1)
// because the traverse takes o(n)
// in deque we sore th index not the element 
//queue will always be in decrreasoing order 
// when adding elemnet in queue check the element at last od quque and you ar e trying to add
// if eleement at last of quque is smaler then remove it until u see a larger eleement 

class Solution 
{
    public int[] maxSlidingWindow(int[] nums, int k) 
    {
        Deque<Integer> dq = new ArrayDeque<>();
        int left =0;
        int[] res = new int[nums.length-k+1];
        int c=0;
        for(int right =0; right<nums.length;right++)
        {
            while(!dq.isEmpty() && nums[right]>nums[dq.peekLast()])
            {
                dq.pollLast();
            }
            dq.offerLast(right);

            if(right-left+1==k)
            {
                res[c++]=nums[dq.peekFirst()];
                left++;
            }

            if(dq.peekFirst()<left)
            {
                dq.pollFirst();
            }
        }
        return res;
    }
}
