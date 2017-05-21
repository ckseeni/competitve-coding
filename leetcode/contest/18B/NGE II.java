public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int a[] = {};
        if(nums.length==0)
            return a;
        int res[] = new int[nums.length];
        int k = 0;
        for(int i=0;i<nums.length;i++){
            int j=0;
            for(j=(i+1)%nums.length;j!=i;j=(j+1)%nums.length){
                if(nums[j]>nums[i]){
                    res[k++] = nums[j];
                    break;
                }    
            }
            if(j==i)
                res[k++] = -1;
        }
        return res;
    }
}/* Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:

Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.

Note: The length of given array won't exceed 10000. */
