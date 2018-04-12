package nl.sey;

public class PalindromeTest {

	/** a palindrome is a text that reads the same left-to-right as right-to-left */
	public static boolean isPalindrome(String str) {
		String rev = new StringBuilder(str).reverse().toString();
	    return str.equals(rev);
	}

	/** optimized as per http://componentsprogramming.com/palindromes/ */	
	public static boolean isPalindromeOptimized(String str) {
	    int n = str.length();
	    for (int i = 0; i < n; ++i) {
	        if (str.charAt(i) != str.charAt(n-i-1)) return false;
	    }
	    return true;
	}
	
	public static String cleanText(String str) {
		return str.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
	}
	
	public static void testPalindromes(String texts[]) {
		for(String text: texts) {
			String result = "'"+text+"'";
			text = cleanText(text);
			boolean test = isPalindrome(text); 
			if(test) {
				result += " is a palindrome";
			} else {
				result += " is NOT a palindrome";
			}
			if(test == isPalindromeOptimized(text)) {
				result += " (confirmed)";
			} else {
				result += " (CONFLICT)";
			}
			System.out.println(result);
		}
	}

	public static void main(String[] args) {
		// sanity check
		if("ditiseentest" != PalindromeTest.cleanText("Dit is een test.")) {
			System.out.println("cleanText FAILED");
		}
		
		String candidates[] = {
				"Baas, neem een racecar, neem een Saab.",
				"Nora bedroog, o zo goor, de baron.",
				"\"Mooie zeden in Epe\", zei oom.",
		};
		PalindromeTest.testPalindromes(candidates);
	}
}
