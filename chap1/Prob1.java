public class Prob1 {
	public static void main(String[] args) {
		test("tuandeptrai", Boolean.FALSE);
		test("randomstring", Boolean.FALSE);
		test("iamnotunique", Boolean.FALSE);
		test("iamunqe", Boolean.TRUE);
		test("abcdefmnk", Boolean.TRUE);
		test("12345789", Boolean.TRUE);
	}

	public static void test(String s, Boolean result) {
		System.out.println("Test with string: " + s);
		if(hasUniqueChars(s) && result == Boolean.TRUE ||
			!hasUniqueChars(s) && result == Boolean.FALSE) 
			System.out.println("TEST PASSED!");
		else System.out.println("TEST FAILED!");
	}

	public static boolean hasUniqueChars(String s) {
		if(s == null || s.trim().isEmpty()) return true;
		boolean[] isUnique = new boolean[256]; // assume the string is 8-bit
		for(char c: s.toCharArray()) {
			if(isUnique[Character.getNumericValue(c)]) return false;
			isUnique[Character.getNumericValue(c)] = true;
		}
		return true;
	}
}