package com.LeetcodeProblems;

public class NumberOfSeniorCitizens {
	String[] details;
//	public int countSeniors(String[] details) {
//        /*
//        * length = 15
//        *10 chars = phone number
//        *1 char gender
//        *2 chars age
//        *2 chars seat allotted
//        *using substring method and then convert extracted substring to integer
//        *increment count 
//        */
//        int seniorCount = 0;
//        for(String info: details){
//            int age = Integer.parseInt(info.substring(11, 13));
//            if(age > 60){
//                seniorCount++;
//            }
//        }
//    return seniorCount;
//    }
	
	public NumberOfSeniorCitizens(String[] details) {
		// TODO Auto-generated constructor stub
		this.details = details;
	}

	/*
	 * another method is using character based extraction
	 * directly accessing age based characters at indices 11 and 12 using ASCII values
	 * 11th index represents the tens places of the age
	 * 12th index represents the ones place of the age
	 * reconstructing the age and check if it exceeds 60
	 * increment counter
	 */
	public int countSeniors(String[] details) {
		int count = 0;
		for(String info: details) {
			int ageTens =  info.charAt(11) - '0';   // difference between ASCII values of index 11 and 0 
			int ageOnes  = info.charAt(12) - '0';    // difference between ASCII values 12 and 0
			int age = ageTens * 10 + ageOnes;  //calculating full age
			if(age > 60) {
				count++;
			}
		}
		System.out.println(count);
		return count;
	}
}
