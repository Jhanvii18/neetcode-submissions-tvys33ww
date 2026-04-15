//1. Treat array as linked list
//2. Find cycle (slow-fast)
//3. Reset slow
//4. Move both → duplicate
/*PROBLEM: Find duplicate without modifying array and O(1) space

IDEA:
- Treat array as linked list
- index → node
- value → next pointer

WHY CYCLE EXISTS:
- n+1 elements but values in [1,n]
- duplicate creates cycle

ALGORITHM:

Phase 1:
- slow = nums[slow]
- fast = nums[nums[fast]]
- find meeting point inside cycle

Phase 2:
- reset slow = nums[0]
- move both 1 step
- meeting point = duplicate

COMPLEXITY:
- Time: O(n)
- Space: O(1)

IMPORTANT:
- Only works because values are valid indices

code if while is used 
int slow = nums[0];
int fast = nums[0];

slow = nums[slow];
fast = nums[nums[fast]];

while(slow != fast)
{
    slow = nums[slow];
    fast = nums[nums[fast]];
}*/

//see basically if it appears more than once na then cycle is there cause in cycle for 
//one element there can we 2 incoming edges
//hence we use floyds to find the cycle first where fast and slow are equal thus
// if tehy are. equal it cycle but to find the starting point of the cycle
// we move slow pointer to zero agin and find it by movuing fast pointer also. by 1 only.
class Solution 
{
    public int findDuplicate(int[] nums) 
    {
        int slow=nums[0];
        int fast=nums[0];
        do
        {
            slow=nums[slow];
            fast=nums[nums[fast]];
        }while(slow!=fast);
        slow=nums[0];
        while(slow!=fast)
        {
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
