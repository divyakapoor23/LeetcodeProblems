package com.LeetcodeProblems;

public class LeetcodeRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// number of senior citizens
		String [] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};
		NumberOfSeniorCitizens x = new NumberOfSeniorCitizens(details);
		x.countSeniors(details);
		
		//left and right sum difference
		int[] nums = {10, 4, 8, 3};
		LeftAndRightSumDifference dif = new LeftAndRightSumDifference(nums);
		dif.leftRightDifference(nums);
	}

}
