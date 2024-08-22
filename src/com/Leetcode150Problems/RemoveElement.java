package com.Leetcode150Problems;

public class RemoveElement {
	public int removeElement(int[] nums, int val) {
        //swapping the current element with the last element 
        //and dispose off the last element
        int i = 0;
        int n = nums.length;
        while(i < n){
            if(nums[i] == val){
                nums[i] = nums[n-1];
                //reduce the size of array
                n--;
            }else{
                i++;
            }
        }
        return n;

    }

}
