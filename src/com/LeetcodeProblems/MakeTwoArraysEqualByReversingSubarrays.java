package com.LeetcodeProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MakeTwoArraysEqualByReversingSubarrays {
	int[] target;
	int[] arr;
	public MakeTwoArraysEqualByReversingSubarrays(int[] target, int[] arr) {
		this.target = target;
		this.arr = arr;
	}
//	First Solution
//	public boolean canBeEqual(int[] target, int[] arr) {
//		Arrays.sort(arr);
//		Arrays.sort(target);
//		for(int i = 0; i < arr.length; i++) {
//			if(arr[i]!= target[i]) {
//				System.out.println("false");
//				return false;
//			}
//		}
//		System.out.println("true");
//        return true;
//    }
	
//	Second Solution
	public boolean canBeEqual(int[] target, int[] arr) {
		//dictionary to maintain frequency count for arr
		Map<Integer, Integer> arrFreq = new HashMap<>();
		for(int num : arr) {
			arrFreq.put(num, arrFreq.getOrDefault(num, 0)+1);
		}
		//Dictionary to maintain frequency count for target
		Map<Integer, Integer> targetFreq = new HashMap<>();
		for(int num : target) {
			targetFreq.put(num, targetFreq.getOrDefault(num, 0)+1);
		}
		
		//number of distinct elements of the 2 arrays are not equal
		if(arrFreq.keySet().size()!= targetFreq.keySet().size()) {
			System.out.println("false");
			return false;
		}
		
		for(int num: arrFreq.keySet()) {
			//frequency for num differs
			if(targetFreq.getOrDefault(num, 0)!=arrFreq.get(num)) {
				System.out.println("false");
				return false;
			}
		}
		System.out.println("true");
		return true;
	}
	
//	Third Solution

}
