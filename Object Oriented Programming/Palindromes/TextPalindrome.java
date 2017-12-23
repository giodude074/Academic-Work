package palindromeMidtermV2;

public class TextPalindrome extends Palindrome {
	public TextPalindrome() {
		super();
	}

	@Override
	public boolean checkIfPalindrome(String string) {
		int x = 0, y = string.length()-1;
		while(y > x)
			if(string.charAt(x++) != string.charAt(y--))
				return false;
		this.updateCount();
		alphanumericCount++;
		return true;
	}
}