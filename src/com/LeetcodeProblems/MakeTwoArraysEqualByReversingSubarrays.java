package com.LeetcodeProblems;

import java.util.Arrays;

public class MakeTwoArraysEqualByReversingSubarrays {
	int[] target;
	int[] arr;
	public MakeTwoArraysEqualByReversingSubarrays(int[] target, int[] arr) {
		this.target = target;
		this.arr = arr;
	}

	public boolean canBeEqual(int[] target, int[] arr) {
		Arrays.sort(arr);
		Arrays.sort(target);
		for(int i = 0; i < arr.length; i++) {
			if(arr[i]!= target[i]) {
				System.out.println("false");
				return false;
			}
		}
		System.out.println("true");
        return true;
    }

}
