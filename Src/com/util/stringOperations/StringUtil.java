package com.util.stringOperations;

public abstract class StringUtil {

    private StringUtil() {

    }

    /**
     * reverses the string characters and then returns the new reversed string
     * object
     * 
     * @param str
     * @return
     */
    public static String reverseString(String str) {
	int length = str.length();
	char c[] = new char[length];
	for (int i = 0; i < length; i++) {
	    c[i] = str.charAt(length - i - 1);
	}
	String reverse = new String(c);
	return reverse;
    }

    public static String reverseString2(String str) {
	int length = str.length();
	char c[] = new char[length];
	if (length % 2 == 0)
	    for (int i = 0; i <= length / 2; i++) {
		c[i] = str.charAt(length - i - 1);
		c[i + length / 2 - 1] = str.charAt(length / 2 - i);
	    }
	else
	    for (int i = 0; i <= length / 2; i++) {
		c[i] = str.charAt(length - i - 1);
		c[i + length / 2] = str.charAt(length / 2 - i);
	    }
	return new String(c);
    }

    public static String insertChar(char c, int i, String word) {
	if (word.length() > 0) {
	    String str1 = word.substring(0, i);
	    String str2 = word.substring(i + 1, word.length());
	    word = "";
	    word += str1 + c + str2;
	}
	return word;
    }

    /**
     * converts the string array passed as argument into a integer array object
     * 
     * @param sarr
     * @return
     */
    public static int[] stringArrayToIntArray(String[] sarr) {
	int[] arr = new int[sarr.length];
	for (int i = 0; i < arr.length; i++) {
	    try {
		arr[i] = Integer.parseInt(sarr[i]);
	    } catch (NumberFormatException e) {
		System.out.println(e.getMessage());
	    }
	}
	return arr;
    }

    /**
     * removes all punctuation characters from the string passed and and returns
     * the modified string object
     * 
     * @param str
     * @return
     */
    public static String removePunctuation(String str) {
	str = str.replaceAll("[^a-zA-Z0-9]{1,}", "");
	return str;
    }

    /**
     * removes all occurrences of a particular string independent of case of
     * character(s).
     * 
     * @param base
     * @param remove
     * @return
     */
    public String removeCaseInSensitive(String base, String remove) {
	return base.replaceAll("(?i)" + remove, "");
    }

    public static boolean isEmptyString(final String string) {
	return string == null || string.length() == 0 || string.trim().length() == 0;
    }

}
