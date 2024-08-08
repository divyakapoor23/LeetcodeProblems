package com.LeetcodeProblems;

public class LeftAndRightSumDifference {
	int[] nums;
	
	public LeftAndRightSumDifference(int [] nums) {
		this.nums = nums;
	}
	
	public int[] leftRightDifference(int[] nums) {
		int n = nums.length;
		int[] ans = new int[n];
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        for(int i = 1; i < n; i++){
            leftSum[i] = leftSum[i-1]+nums[i-1];
            System.out.println(leftSum[i]);
        }
        
        for(int i = n - 2; i >= 0; i--) {
        	rightSum[i] = rightSum[i+1] + nums[i+1];
        	System.out.println(rightSum[i]);
        }
        
        for(int i = 0; i < n; i++) {
        	ans[i] = Math.abs(rightSum[i] - leftSum[i]);
        	System.out.println(ans[i]);
        }
        return ans;
	}
}
