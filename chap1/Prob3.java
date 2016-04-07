public class Prob3 {
	public static void main(String[] args) {
		test(" ", "%20");
		test("  ", "%20%20");
		test("hot boy", "hot%20boy");
		test("a   b c", "a%20%20%20b%20c");
		test(" a ", "%20a%20");
		test(" a  b ", "%20a%20%20b%20");
		test(" a     b ", "%20a%20%20%20%20%20b%20");
	}

	public static void test(String s, String result) {
		System.out.println("Test with string: '" + s + "'");
		if(replaceEmpty(s).equals(result)) System.out.println("TEST PASSED!");
		else System.out.println("TEST FAILED!");
	}

	public static String replaceEmpty(String s) {
		int spaceCount = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') spaceCount++;
		}
		int actualLen = s.length() + 2*spaceCount;
		StringBuffer buffer = new StringBuffer();
		buffer.setLength(actualLen);
		int lastOfBuffer = actualLen - 1;
		for(int i = s.length() - 1; i >= 0; i--) {
			if(s.charAt(i) == ' ') {
				buffer.setCharAt(lastOfBuffer, '0');
				buffer.setCharAt(lastOfBuffer-1, '2');
				buffer.setCharAt(lastOfBuffer-2, '%');
				lastOfBuffer -= 3;
			} else {
				buffer.setCharAt(lastOfBuffer, s.charAt(i));
				lastOfBuffer--;
			}
		}
		return buffer.toString();
	}
}