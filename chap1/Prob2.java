public class Prob2 {
	public static void main(String[] args) {
		test("tuandeptrai", "untapediart", Boolean.TRUE);
		test("abcdef", "fadebc", Boolean.TRUE);
		test("a","a", Boolean.TRUE);
		test("abc", "abcd", Boolean.FALSE);
		test("abcdef", "afedbn", Boolean.FALSE);
		test("mknalg", "qpyrlg", Boolean.FALSE);
	}

	public static void test(String s1, String s2, Boolean result) {
		System.out.println("Test with string: " + s1 + " and " + s2);
		if(isPermutation(s1, s2) && result == Boolean.TRUE ||
			!isPermutation(s1, s2) && result == Boolean.FALSE) 
			System.out.println("TEST PASSED!");
		else System.out.println("TEST FAILED!");
	}

	public static boolean isPermutation(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		int[] frequency = new int[256]; //assume strings are 8-bit
		for(int i = 0; i < s1.length(); i++) {
			frequency[Character.getNumericValue(s1.charAt(i))]++;
			frequency[Character.getNumericValue(s2.charAt(i))]--;
		}
		for(int i = 0; i < 256; i++) {
			if(frequency[i] < 0) return false;
		}
		return true;
	}
}