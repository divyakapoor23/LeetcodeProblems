package com.LeetcodeProblems;

import java.util.HashSet;
import java.util.Set;

public class LongestRepeatingSubstring {
	String s;
	
	public LongestRepeatingSubstring(String s) {
		this.s = s;
	}
	
//brute force with set o(n^3) time complexity
    public int longestRepeatingSubstring(String s) {
        Set<String> seenSubstrings = new HashSet<>();
        int maxLength = s.length() - 1;

        for (int start = 0; start <= s.length(); start++) {
            int end = start;
            // If the remaining substring is shorter than maxLength,
            // reset the loop
            if (end + maxLength > s.length()) {
                if (--maxLength == 0) break;
                start = -1;
                seenSubstrings.clear();
                continue;
            }
            // Extract substring of length maxLength
            String currentSubstring = s.substring(end, end + maxLength);
            // If the substring is already in the set,
            // it means we've found a repeating substring
            if (!seenSubstrings.add(currentSubstring)) {
            	System.out.println(maxLength);
                return maxLength;
            }
        }
        System.out.println(maxLength);
        return maxLength;
    }
	
}
