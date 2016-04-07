public class Prob4 {
	public static void main(String[] args) {
		test("a", Boolean.TRUE);
		test("aba", Boolean.TRUE);
		test("aab", Boolean.TRUE);
		test("abccdab", Boolean.TRUE);
		test("", Boolean.FALSE);
		test("ab", Boolean.FALSE);
		test("abc", Boolean.FALSE);
		test("abcdedabee", Boolean.FALSE);
		test("aabbdc", Boolean.FALSE);
	}

	public static void test(String s, Boolean result) {
		System.out.println("Test with string: '" + s + "'");
		if(isPalindromPermu(s) == result) System.out.println("TEST PASSED!");
		else System.out.println("TEST FAILED!");
	}

	public static boolean isPalindromPermu(String s) {
		if(s.isEmpty()) return false;
		int[] frequency = new int[256]; // assume the string is 8-bit
		int oddCount = 0;
		for(char c: s.toCharArray()) {
			frequency[Character.getNumericValue(c)]++;
			if(frequency[Character.getNumericValue(c)] % 2 == 0) oddCount--;
			else oddCount++;
		}
		return oddCount < 2;
	}
}