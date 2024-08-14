package com.LeetcodeProblems;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
/**
compute sum of all non-empty continous subarrays from the array 
sort them in decreasing order 
creat new array n * (n+1)/2 numbers 
return the sum of numbers from index left to right (indexed from 1) in new array 
return in modulo of 10^9 + 7


nums = [1,2,3,4]
left = 1 right = 5
new array of new numbers = 4 * (4+1)/2 4* 2.5 = 10 elements (length of array)
new Array = [1, 3, 6, 10, 2, 5, 9, 3, 7, 4]
sort them; sorted array = [1,2,3,3,4,5,6,7,9,10]
sum of left to right = 1 + 2 + 3 + 3 + 4 = 13

left = 3 right = 4
sum of left to right = 3 + 3 = 6

left = 1 right = 10
sum of left to right = 1+2+3+3+4+5+6+7+9+10 = 50
 */
public class RangeSum {
	int[] nums;
	int n;
	int left;
	int right; 
	
	public RangeSum(int[] nums, int n, int left, int right) {
		this.nums = nums;
		this.n = n; 
		this.left = left;
		this.right = right;
	}
	//Solution 1 Brute Force
	/**
	public int rangeSum(int[] nums, int n, int left, int right) {
        ArrayList<Integer> storeSubarray = new ArrayList<>(); // to store sums of each subarray
        //calculate the sum of left and right indices after sorting
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            //iterate thru all indices ahead of the current index
            for(int j = i; j < nums.length; j++){
                sum+=nums[j];
                storeSubarray.add(sum);
            }
        }
        //store all subarray values in increasing order
        Collections.sort(storeSubarray);

        //find the sum of all values between left and right 
        int range = 0, mod =(int)1e9 + 7;
        for(int i = left-1; i <=right-1; i++){
            range = (range + storeSubarray.get(i)) % mod;
        }
        System.out.println(range);
        return range;
    }

	//Solution 2 Priority Queue
	//improved spaced complexity O(n); Time Complexity Same O(n^2)

	public int rangeSum(int[] nums, int n, int left, int right) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(
	            new Comparator<int[]>(){
	                @Override
	                public int compare(int[] o1, int[] o2){
	                    return o1[0]-o2[0];
	                }
	            }
	        );
	        for(int i = 0; i < n; i++){
	            pq.offer(new int[] {nums[i], i});
	        }

	        int ans = 0, mod = 1000000007;
	        for(int i = 1; i <=right; i++){
	            int[] p = pq.poll();
	            if(i >=left)ans = (ans+p[0])%mod;
	            if(p[1]<n-1){
	                p[0]+= nums[++p[1]];
	                pq.offer(p);
	            }
	        }
	        System.out.println(ans);
	        return ans;
	}
	*/
	
	//Solution 3 Binary Search and Sliding Window

    private static final int MOD = 1000000007;

    public int rangeSum(int[] nums, int n, int left, int right) {
        long result =
            (sumOfFirstK(nums, n, right) - sumOfFirstK(nums, n, left - 1)) %
            MOD;
        // Ensure non-negative result
        return (int) ((result + MOD) % MOD);
    }

    // Helper function to count subarrays with sum <= target and their total sum.
    private Map.Entry<Integer, Long> countAndSum(
        int[] nums,
        int n,
        int target
    ) {
        int count = 0;
        long currentSum = 0, totalSum = 0, windowSum = 0;
        for (int j = 0, i = 0; j < n; ++j) {
            currentSum += nums[j];
            windowSum += nums[j] * (j - i + 1);
            while (currentSum > target) {
                windowSum -= currentSum;
                currentSum -= nums[i++];
            }
            count += j - i + 1;
            totalSum += windowSum;
        }
        return new AbstractMap.SimpleEntry<>(count, totalSum);
    }

    // Helper function to find the sum of the first k smallest subarray sums.
    private long sumOfFirstK(int[] nums, int n, int k) {
        int minSum = Arrays.stream(nums).min().getAsInt();
        int maxSum = Arrays.stream(nums).sum();
        int left = minSum, right = maxSum;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (countAndSum(nums, n, mid).getKey() >= k) right = mid - 1;
            else left = mid + 1;
        }
        Map.Entry<Integer, Long> result = countAndSum(nums, n, left);
        // There can be more subarrays with the same sum of left.
        return result.getValue() - left * (result.getKey() - k);
   }
}





