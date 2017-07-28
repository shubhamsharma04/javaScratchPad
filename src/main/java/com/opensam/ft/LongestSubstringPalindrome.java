package com.opensam.ft;

public class LongestSubstringPalindrome {

	public String longestPalindrome(String s) {
		int resultStartIndex = 0;
		int resultEndIndex = 0;
		int length = s.length();
		for (int startIndex = 0; startIndex < length; startIndex++) {
			for (int endIndex = length; endIndex > 0; endIndex--) {
				if (endIndex - startIndex > resultEndIndex - resultStartIndex) {
					if (isPalindrome(s.substring(startIndex, endIndex))) {
						resultStartIndex = startIndex;
						resultEndIndex = endIndex;
					}
				}
			}
		}
		return s.substring(resultStartIndex, resultEndIndex);

	}

	private boolean isPalindrome(String str) {
		boolean isPalindrome = true;
		int endIndex = str.length() - 1;
		int startIndex = 0;
		while (startIndex <= endIndex) {
			if (str.charAt(startIndex) != str.charAt(endIndex)) {
				isPalindrome = false;
				break;
			}
			startIndex++;
			endIndex--;
		}
		return isPalindrome;
	}
}
