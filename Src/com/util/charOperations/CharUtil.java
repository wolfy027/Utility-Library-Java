package com.util.charOperations;

public abstract class CharUtil {

	public static boolean isVowel(char c) {
		return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'
				|| c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}

	public static boolean isSpace(char c) {
		return (Character.isWhitespace(c));
	}


	public static boolean isPunctuation(char c) {
		return (!Character.isLetterOrDigit(c));
	}

	public static boolean isConsonant(char c) {
		return (!isVowel(c) && !isSpace(c) && !isPunctuation(c));
	}

}
