package on_class;

public class MyStrings {
	public static int countChars(String str, char ch, boolean isIgnoreCase) {
		if (isIgnoreCase) {
			str = str.toLowerCase();
			ch = Character.toLowerCase(ch);
		}

		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch) {
				count++;
			}
		}

		return count;
	}
	

	public static void main(String[] args) {
		String str = "Hello EveryBody";
		System.out.println("Có tất cả " + MyStrings.countChars(str, 'e', false) + " ký tự e");
	}
}
