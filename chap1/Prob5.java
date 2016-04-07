import java.lang.Math;
import java.lang.Math;
public class Prob5 {
	public static void main(String[] args) {
		test("", "a", Boolean.TRUE);
		test("a", "b", Boolean.TRUE);
		test("a", "ab", Boolean.TRUE);
		test("abcd", "abdd", Boolean.TRUE);
		test("abcd", "acd", Boolean.TRUE);
		test("", "ab", Boolean.FALSE);
		test("a", "bc", Boolean.FALSE);
		test("abcd", "bd", Boolean.FALSE);
		test("aaac", "abad", Boolean.FALSE);
	}

	public static void test(String s1, String s2, Boolean result) {
		System.out.println("Test with string: '" + s1 + "' and '" + s2 + "'");
		if(isOneEdit(s1, s2) == result) System.out.println("TEST PASSED!");
		else System.out.println("TEST FAILED!");
	}

	public static boolean isOneEdit(String s1, String s2) {
		if(Math.abs(s1.length() - s2.length()) > 1) return false;
		boolean foundDiff = false;
		String shorter = s1;
		String longer = s2;
		if(s1.length() > s2.length()) {
			shorter = s2;
			longer = s1;
		}
		int shortIndex = 0;
		int longIndex = 0;
		while(shortIndex < shorter.length()) {
			if(shorter.charAt(shortIndex) != longer.charAt(longIndex)) {
				if(foundDiff) return false;
				foundDiff = true;
				if(s1.length() != s2.length()) longIndex++;
			} else {
				shortIndex++;
				longIndex++;
			}
		}
		return true;
	}
}