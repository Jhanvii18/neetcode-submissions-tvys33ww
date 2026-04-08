/*### Summary

This video explains a classic algorithmic problem involving **finding the minimum speed at which Coco can eat all the banana piles within a given time limit**. The problem is framed around an array where each element represents the number of bananas in a pile, and Coco must finish eating all bananas within a specified number of hours.

### Problem Statement and Examples

- You are given an array representing piles of bananas; each element is the number of bananas in that pile.
- Coco can choose an eating speed, $k$, representing bananas eaten per hour.
- Coco must finish eating all bananas within a given total time, $H$ hours.
- Coco cannot switch piles in the middle of an hour. If there are leftover bananas in a pile at the end of one hour, she continues eating that pile in the next hour.
- The goal is to find the **minimum eating speed $k$ such that Coco finishes all bananas within $H$ hours**.

#### Example Test Case Breakdown

| Pile Index | Bananas in Pile | Eating Speed (bananas/hour) | Hours Taken (Ceiling of pile size / speed) |
|------------|-----------------|-----------------------------|---------------------------------------------|
| 1          | 3               | 1                           | 3                                           |
| 2          | 6               | 1                           | 6                                           |
| 3          | 7               | 1                           | 7                                           |
| 4          | 11              | 1                           | 11                                          |

- Total hours with speed 1: $3 + 6 + 7 + 11 = 27$ hours, which exceeds the limit of 8 hours.
- Increasing speed to 2 bananas/hour reduces total time but still exceeds 8 hours.
- At speed 4 bananas/hour, Coco can finish exactly in 8 hours (the target time).
- At very high speeds (e.g., 11 bananas/hour), Coco finishes much quicker (4 hours), but the goal is to find the minimum sufficient speed.

### Brute Force Approach

- Start with speed $k = 1$ and incrementally increase speed.
- For each speed, calculate the total time taken to finish all piles using:

  $$ \text{time} = \sum_{i=1}^{n} \lceil \frac{\text{pile}_i}{k} \rceil $$

- Stop when the total time is less than or equal to $H$.
- This approach is simple but inefficient—iterating through potentially many speeds.

### Optimized Approach: Binary Search

- **Key Insight:** Minimum speed $k_{min} = 1$, maximum speed $k_{max} = \max(\text{piles})$.
- Use binary search between $k_{min}$ and $k_{max}$ to find the minimal $k$ that satisfies the time constraint.
- At each step:
  - Calculate mid speed $k_{mid} = \lfloor \frac{k_{min} + k_{max}}{2} \rfloor$.
  - Calculate total hours needed with speed $k_{mid}$.
  - If total hours $\leq H$, try to reduce $k_{max}$ to $k_{mid}$ (search left half).
  - Else, increase $k_{min}$ to $k_{mid} + 1$ (search right half).
- Continue until $k_{min} = k_{max}$, which is the minimum speed.

### Time Complexity

| Component                  | Complexity                |
|----------------------------|---------------------------|
| Calculating total hours     | $O(n)$ (iterate over piles) |
| Binary search iterations    | $O(\log m)$, where $m = \max(\text{piles})$ |

- **Overall time complexity:** $$O(n \log m)$$
- **Space complexity:** $$O(1)$$ (only pointers and counters used)

### Algorithmic Steps (Summary)

- Initialize:
  - $low = 1$
  - $high = \max(\text{piles})$
- While $low < high$:
  - $mid = \lfloor \frac{low + high}{2} \rfloor$
  - Calculate total hours with speed $mid$.
  - If total hours $\leq H$, set $high = mid$.
  - Else, set $low = mid + 1$.
- Return $low$ as the minimum speed.

### Additional Key Points

- The problem is a classic example of how **binary search can be applied to search for an optimal numeric parameter** rather than searching for a specific element.
- The **"ceiling" function** is crucial to correctly calculating time because partial hours are not allowed when switching piles.
- The brute force approach can be very slow for large inputs, but binary search drastically reduces runtime by halving the search space each iteration.
- The video includes a **code dry run** to illustrate how the binary search approach works in practice.
- The solution highlights that recognizing when to apply binary search can lead to **efficient optimization of search problems with numeric boundaries**.

### Key Insights and Terminology

- **Divide and conquer paradigm:** Used here as binary search to reduce search space.
- **Ceiling function:** $\lceil x \rceil$ rounds up partial hours since switching piles during an hour is not allowed.
- **Minimum speed:** At least 1 banana/hour.
- **Maximum speed:** At most the size of the largest pile.
- **Time limit $H$:** Total hours within which the bananas must be eaten.
- **Binary search for optimization:** Efficiently finds the minimal speed meeting the time constraint.

### Summary Table of Example Speeds and Times

| Speed $k$ (bananas/hour) | Total Hours Needed | Meets Time Limit ($H=8$)? |
|--------------------------|--------------------|---------------------------|
| 1                        | 27                 | No                        |
| 2                        | 15                 | No                        |
| 3                        | 10                 | No                        |
| 4                        | 8                  | **Yes (minimum speed)**   |
| 5                        | 7                  | Yes                       |
| 6                        | 6                  | Yes                       |
| 11                       | 4                  | Yes                       |

### Conclusion

The video thoroughly explains a **problem of finding the minimum eating speed** using a binary search approach. The key takeaway is that the binary search paradigm can be used to optimize a numeric search problem by iteratively narrowing down the feasible range of speeds. This results in an efficient $O(n \log m)$ time complexity algorithm, far superior to the brute force linear search.

The presenter also encourages viewers to comment with alternative approaches or optimizations, highlighting the educational intent behind the explanation.**/
class Solution 
{
    public int minEatingSpeed(int[] piles, int h) 
    {
        int max = piles[0];
        for(int i=0;i<piles.length;i++)
        {
            if(piles[i]>max)
            {
                max=piles[i];
            }
        }
        int high = max;
        int low =1;//speed cant be 0
        while(low<=high)
        {
            int speed = (high+low)/2;
            int sum =0;
            for(int i =0;i<piles.length;i++)
            {
                int p = piles[i];
                sum = sum+((int)Math.ceil((double)p/speed));
                //or use (p+speed-1/speed)
            }
            if(sum<=h)// it must be less than equal to not less than
            {
               high=speed-1;
            }
            else//if the sum u get is greater than the eating speed then u like increse the speed so that hours is less
            {
               low=speed+1;
            }
            // its not guareented low==high is got.
        }
        return low;//optimum low = smallest valid answer
    }
}
